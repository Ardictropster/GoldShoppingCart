package com.shoppingcart.dao.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.CustomerOrderDAO;
import com.shoppingcart.entities.CustomerOrder;

/**
 * DAO implementation of Customer DAO
 * @author kenarayan
 *
 */

@Repository
@Transactional
public class CustomerOrderDAOimpl implements CustomerOrderDAO {
	
	@Autowired
	private SessionFactory sFactory;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sFactory.openSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
		session.close();
	}


}
