/**
 * 
 */
package com.shoppingcart.dao.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.CartDAO;
import com.shoppingcart.entities.Cart;
import com.shoppingcart.service.CustomerOrderService;

/**
 * @author kenarayan
 *
 */
@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sFactory;
	
	@Autowired
	private CustomerOrderService customerOrderService;

	public Cart getCartByCartId(int cartId) {
		Session session = sFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class,cartId);
		return cart;
	}

	public Cart validateCart(int cartId) throws Exception {
		Cart cart = getCartByCartId(cartId);
		if(cart == null || cart.getCartItem().size() == 0){
			throw new Exception("Cart id : "+cartId+" does not exist");
		}
		updateCart(cart);
		return cart;
	}

	public void updateCart(Cart cart) {
		Session session = sFactory.openSession();
		int cartId = cart.getCartId();
		double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
		cart.setTotalPrice(grandTotal);
		session.saveOrUpdate(cart);
		session.flush();
		session.close();
		
	}

}
