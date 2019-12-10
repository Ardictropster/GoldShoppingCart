package com.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.service.CustomerQueriesDAO;
import com.shoppingcart.entities.Queries;
import com.shoppingcart.service.CustomerQueriesService;

/**
 * service implementation of customer queries
 * 
 * @author kenarayan
 *
 */

@Service
public class CustomerQueriesServiceImpl implements CustomerQueriesService {

	@Autowired
	private CustomerQueriesDAO customerQueryDao;

	public void addQuery(Queries queries) {
		customerQueryDao.addQuery(queries);
	}

}
