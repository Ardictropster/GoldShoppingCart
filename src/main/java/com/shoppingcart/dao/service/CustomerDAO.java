package com.shoppingcart.dao.service;

import java.util.List;

import com.shoppingcart.entities.Customer;

/**
 * Service interface of customer module
 * 
 * @author kenarayan
 *
 */
public interface CustomerDAO {
	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);
}
