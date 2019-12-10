package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entities.Customer;

/**
 * Service interface of Customer module
 * 
 * @author kenarayan
 *
 */
public interface CustomerService {
	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);
}
