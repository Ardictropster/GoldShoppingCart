package com.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.service.CartItemDAO;
/**
 * Service implementation of cart item
 */
import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.CartItem;
import com.shoppingcart.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDAO cartItemDao;

	public CartItemDAO getCartItemDao() {
		return cartItemDao;
	}

	public void setCartItemDao(CartItemDAO cartItemDao) {
		this.cartItemDao = cartItemDao;
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDao.addCartItem(cartItem);
	}

	@Override
	public void removeCartItem(int cartItemId) {
		cartItemDao.removeCartItem(cartItemId);
	}

	@Override
	public void removeAllCartItems(Cart cart) {
		cartItemDao.removeAllCartItems(cart);
	}

}
