package com.shoppingcart.service;

import com.shoppingcart.entities.CustomerOrder;

/**
 * Service interface of customer order module
 * 
 * @author kenarayan
 *
 */
public interface CustomerOrderService {
	void addCustomerOrder(CustomerOrder customerOrder);

	double getCustomerOrderGrandTotal(int cartId);
}
