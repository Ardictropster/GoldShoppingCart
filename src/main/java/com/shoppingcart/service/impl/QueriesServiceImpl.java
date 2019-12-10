package com.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.service.QueriesDAO;
import com.shoppingcart.entities.Queries;
import com.shoppingcart.service.QueriesService;

/**
 * Service implementation of user queries module
 * 
 * @author kenarayan
 *
 */
@Service
public class QueriesServiceImpl implements QueriesService {

	@Autowired
	private QueriesDAO queryDao;

	public QueriesDAO getQueryDao() {
		return queryDao;
	}

	public void setQueryDao(QueriesDAO queryDao) {
		this.queryDao = queryDao;
	}

	public void addQuery(Queries queries) {
		queryDao.addQuery(queries);
	}

}
