package com.shoppingcart.dao.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.CustomerDAO;
import com.shoppingcart.entities.Authorities;
import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sFactory;

	public void addCustomer(Customer customer) {
		Session session = sFactory.openSession();
		//customer.getUsers().setEnabled(true);
		Authorities auth = new Authorities();
		auth.setAuthorities("ROLE_USER");
		auth.setEmailId(customer.getUsers().getEmailId());
		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		session.save(customer);
		session.save(auth);
		session.flush();
		session.close();
	}

	public List<Customer> getAllCustomers() {
		Session session = sFactory.openSession();
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

	public Customer getCustomerByemailId(String emailId) {
		Session session = sFactory.openSession();
		Customer customer = (Customer) session.createCriteria(Customer.class, emailId);
		return customer;
	}

}
