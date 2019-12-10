package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.CustomerDAO;
import com.shoppingcart.entities.Customer;
import com.shoppingcart.service.CustomerService;

/**
 * service implementation of customer interface
 * 
 * @author kenarayan
 *
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO custDao;

	public void addCustomer(Customer customer) {
		custDao.addCustomer(customer);
	}

	public List<Customer> getAllCustomers() {
		return custDao.getAllCustomers();
	}

	public Customer getCustomerByemailId(String emailId) {
		return custDao.getCustomerByemailId(emailId);
	}

}
