package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.dao.service.UserDAO;
import com.shoppingcart.entities.User;
import com.shoppingcart.service.UserService;

/**
 * Service implementation class - User
 * 
 * @author kenarayan
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);
	}

	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional
	public User getUserById(String userId) {
		return userDao.getUserById(userId);
	}

}
