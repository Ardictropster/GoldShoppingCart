package com.shoppingcart.dao.service;

import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.CartItem;

/**
 * DAO interface of cart item module
 * 
 * @author kenarayan
 *
 */
public interface CartItemDAO {
	void addCartItem(CartItem cartItem);

	void removeCartItem(int cartItemId);

	void removeAllCartItems(Cart cart);
}
