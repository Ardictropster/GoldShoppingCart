package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entities.User;

/**
 * Interface for user related activities
 * 
 * @author kenarayan
 *
 */
public interface UserService {
	List<User> getAllUsers();

	void deleteUser(String userId);

	void addUser(User user);

	User getUserById(String userId);
}
