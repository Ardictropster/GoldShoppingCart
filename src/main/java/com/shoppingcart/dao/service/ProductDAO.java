package com.shoppingcart.dao.service;

import java.util.List;

import com.shoppingcart.entities.Product;

/**
 * DAO interface of Product module
 * 
 * @author kenarayan
 *
 */
public interface ProductDAO {
	List<Product> getAllProducts();

	Product getProductById(int productId);

	void deleteProduct(int productId);

	void addProduct(Product product);

	void editProduct(Product product);
}
