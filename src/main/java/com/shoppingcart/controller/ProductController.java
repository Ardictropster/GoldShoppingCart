package com.shoppingcart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.entities.Product;
import com.shoppingcart.service.ProductService;

/**
 * Controller class for product module
 * 
 * @author kenarayan
 *
 */

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductService getProdService() {
		return productService;
	}

	public void setProdService(ProductService productService) {
		this.productService = productService;
	}

	/*@Bean
	public MultipartResolver multiPartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}*/

	@RequestMapping(value = "/getAllProducts")
	public ModelAndView getAppProducts() {
		List<Product> prodList = productService.getAllProducts();
		return new ModelAndView("prodList", "prodList", prodList);
	}

	@RequestMapping(value = "getProdById/{productId}")
	public ModelAndView getProdById(@PathVariable(value = "prodId") int productId) {
		Product product = productService.getProductById(productId);
		return new ModelAndView("prodPage", "product", product);
	}

	@RequestMapping(value = "/admin/delete/{prodId}")
	public String deleteProduct(@PathVariable(value = "prodId") int productId) {
		Path path = Paths
				.get("D:/java/workspace/ShoppingCart/MyShoppingCart/src/main/webapp/WEB-INF/resource/images/products/"
						+ productId + ".jpg");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		productService.deleteProduct(productId);
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.GET)
	public String getProductFrom(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@RequestMapping(value = "/admin/product/addProduct", method = RequestMethod.POST)
	 public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addProduct";
		}
		 
		productService.addProduct(product);
		MultipartFile image = product.getProductImage();
		if (image != null && !image.isEmpty()) {
			Path path = Paths
					.get("D:/java/workspace/ShoppingCart/MyShoppingCart/src/main/webapp/resources/images/products"
							+ product.getProdId() + ".jpg");

			try {
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "redirect:/getAllProducts";
	}

	@RequestMapping(value = "/admin/product/editProduct/{productId}")
	public ModelAndView getEditForm(@PathVariable(value = "productId") int productId) {
		Product product = productService.getProductById(productId);
		return new ModelAndView("editProduct", "editProductObj", product);
	}

	@RequestMapping(value = "/admin/product/editProduct", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
		productService.editProduct(product);
		return "redirect:/getAllProducts";
	}

	@RequestMapping("/getProductsList")
	public @ResponseBody List<Product> getProductsListInJson() {
		return productService.getAllProducts();
	}

	@RequestMapping("/productsListAngular")
	public String getProducts() {
		return "productListAngular";
	}

	@ModelAttribute("product")
	public Product loadEmptyBeanModel() {
		return new Product();
	}

}
