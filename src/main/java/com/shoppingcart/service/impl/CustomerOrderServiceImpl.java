package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.service.CustomerOrderDAO;
import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.CartItem;
import com.shoppingcart.entities.CustomerOrder;
import com.shoppingcart.service.CartService;
import com.shoppingcart.service.CustomerOrderService;

/**
 * Service implementation of customer order module
 * 
 * @author kenarayan
 *
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDAO customerDao;

	@Autowired
	private CartService cartService;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerDao.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(int cartId) {
		double totalAmount = 0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		for (CartItem item : cartItems) {
			totalAmount += item.getPrice();
		}
		return totalAmount;
	}

}
