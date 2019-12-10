package com.shoppingcart.service;

import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.CartItem;

/**
 * Service interface of cart item
 * 
 * @author kenarayan
 *
 */
public interface CartItemService {
	void addCartItem(CartItem cartItem);

	void removeCartItem(int cartItemId);

	void removeAllCartItems(Cart cart);
}
