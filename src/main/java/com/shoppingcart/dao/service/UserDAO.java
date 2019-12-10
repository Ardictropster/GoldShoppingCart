package com.shoppingcart.dao.service;

import java.util.List;

import com.shoppingcart.entities.User;

/**
 * DAO Interface for User module
 * 
 * @author kenarayan
 *
 */
public interface UserDAO {
	List<User> getAllUsers();

	void deleteUser(String userId);

	void addUser(User user);

	User getUserById(String userId);
}
