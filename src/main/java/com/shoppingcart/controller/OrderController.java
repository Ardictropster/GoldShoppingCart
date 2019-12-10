package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.Customer;
import com.shoppingcart.entities.CustomerOrder;
import com.shoppingcart.service.CartService;
import com.shoppingcart.service.CustomerOrderService;

/**
 * Controller class of order management
 * 
 * @author kenarayan
 *
 */
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderService customerOrderService;
	

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public CustomerOrderService getCustomerOrderService() {
		return customerOrderService;
	}

	public void setCustomerOrderService(CustomerOrderService customerOrderService) {
		this.customerOrderService = customerOrderService;
	}

	@RequestMapping("/order/{cartId}")
	public String createOrder(@PathVariable("cartId") int cartId) {
		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart = cartService.getCartByCartId(cartId);
		customerOrder.setCart(cart);
		Customer customer = cart.getCustomer();
		customerOrder.setCustomer(customer);
		customerOrder.setShippingAddress(customer.getShippingAddress());
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrderService.addCustomerOrder(customerOrder);
		return "redirect:/checkout?cartId=" + cartId;
	}
}
