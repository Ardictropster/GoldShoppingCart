package com.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.service.CartDAO;
import com.shoppingcart.entities.Cart;
import com.shoppingcart.service.CartService;

/**
 * service implementation of cart module
 * 
 * @author kenarayan
 *
 */

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDao;

	public CartDAO getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDAO cartDao) {
		this.cartDao = cartDao;
	}

	public Cart getCartByCartId(int cartId) {
		return cartDao.getCartByCartId(cartId);
	}

}
