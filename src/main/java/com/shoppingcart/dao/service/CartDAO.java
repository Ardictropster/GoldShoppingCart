/**
 * 
 */
package com.shoppingcart.dao.service;

import com.shoppingcart.entities.Cart;

/**
 * DAO interface of Cart module
 * 
 * @author kenarayan
 *
 */
public interface CartDAO {
	Cart getCartByCartId(int cartId);

	Cart validateCart(int cartId) throws Exception;

	void updateCart(Cart cart);
}
