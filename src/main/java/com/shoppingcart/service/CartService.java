package com.shoppingcart.service;

import com.shoppingcart.entities.Cart;

/**
 * service interface of Cart module
 * 
 * @author kenarayan
 *
 */
public interface CartService {
	Cart getCartByCartId(int cartId);
}
