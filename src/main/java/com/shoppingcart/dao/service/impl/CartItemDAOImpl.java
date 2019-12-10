package com.shoppingcart.dao.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.CartItemDAO;
import com.shoppingcart.entities.Cart;
import com.shoppingcart.entities.CartItem;

/**
 * DAO implementation of cart item module
 * 
 * @author kenarayan
 *
 */
@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sFactory;

	public void addCartItem(CartItem cartItem) {
		Session session = sFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
	}

	public void removeCartItem(int cartItemId) {
		Session session = sFactory.openSession();
		CartItem cartItem = (CartItem) session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		Cart cart = cartItem.getCart();
		List<CartItem> cartItems = cart.getCartItem();
		cartItems.remove(cartItem);
		session.flush();
		session.close();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItem();
		for (CartItem cartItem : cartItems) {
			removeCartItem(cartItem.getCartItemId());
		}
	}

}
