package com.shoppingcart.dao.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingcart.dao.service.ProductDAO;
import com.shoppingcart.entities.Product;

/**
 * DAO implementation class of Product module
 * @author kenarayan
 *
 */

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sFactory;

	public List<Product> getAllProducts() {
		Session session = sFactory.openSession();
		List<Product> products = session.createCriteria(Product.class).list();
		session.flush();
		session.close();
		return products;
	}

	public Product getProductById(int productId) {
		Session session = sFactory.openSession();
		Product product = (Product) session.get(Product.class, productId);
		return product;
	}

	public void deleteProduct(int productId) {
		Session session = sFactory.openSession();
		Product product = (Product) session.get(Product.class, productId);
		session.delete(product);
		session.flush();
		session.close();
	}

	public void addProduct(Product product) {
		Session session = sFactory.openSession();
		session.save(product);
		session.flush();
		session.close();
	}

	public void editProduct(Product product) {
		Session session = sFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
		session.close();
	}

}
