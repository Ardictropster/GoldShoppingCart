package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.ProductDAO;
import com.shoppingcart.entities.Product;
import com.shoppingcart.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO prodDao;

	public ProductDAO getProdDao() {
		return prodDao;
	}

	public void setProdDao(ProductDAO prodDao) {
		this.prodDao = prodDao;
	}

	@Transactional
	public List<Product> getAllProducts() {
		return prodDao.getAllProducts();
	}

	@Transactional
	public Product getProductById(int productId) {
		return prodDao.getProductById(productId);
	}

	@Transactional
	public void deleteProduct(int productId) {
		prodDao.deleteProduct(productId);
	}

	@Transactional
	public void addProduct(Product product) {
		prodDao.addProduct(product);
	}

	@Transactional
	public void editProduct(Product product) {
		prodDao.editProduct(product);
	}

}
