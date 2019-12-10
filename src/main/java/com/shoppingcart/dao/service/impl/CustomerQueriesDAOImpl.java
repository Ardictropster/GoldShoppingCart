package com.shoppingcart.dao.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.CustomerQueriesDAO;
import com.shoppingcart.entities.Queries;

/**
 * DAO service implementation of customer queries
 * 
 * @author kenarayan
 *
 */
@Repository
@Transactional
public class CustomerQueriesDAOImpl implements CustomerQueriesDAO {

	@Autowired
	private SessionFactory sFactory;

	public void addQuery(Queries queries) {
		Session session = sFactory.openSession();
		session.save(queries);
		session.close();
	}

}
