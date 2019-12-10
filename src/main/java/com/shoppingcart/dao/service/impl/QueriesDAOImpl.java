package com.shoppingcart.dao.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.QueriesDAO;
import com.shoppingcart.entities.Queries;

@Repository
public class QueriesDAOImpl implements QueriesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addQuery(Queries queries) {
		Session session = sessionFactory.openSession();
		session.save(queries);
		session.close();
	}

}
