package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entities.Product;

/**
 * Service interface of product module
 * 
 * @author kenarayan
 *
 */
public interface ProductService {
	List<Product> getAllProducts();

	Product getProductById(int productId);

	void deleteProduct(int productId);

	void addProduct(Product product);

	void editProduct(Product product);
}
