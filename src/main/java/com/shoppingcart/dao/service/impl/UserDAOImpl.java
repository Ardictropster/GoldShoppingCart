package com.shoppingcart.dao.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingcart.dao.service.UserDAO;
import com.shoppingcart.entities.User;

/**
 * Implementation class for user DAO service
 * 
 * @author kenarayan
 *
 */

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sFactory;

	public List<User> getAllUsers() {
		Session session = sFactory.openSession();
		List<User> usersList = session.createCriteria(User.class).list();
		System.out.println("List of user : " + usersList);
		session.close();
		return usersList;
	}

	public void deleteUser(String userId) {
		Session session = sFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.delete(user);
		session.flush();
		session.close();
	}

	public void addUser(User user) {
		Session session = sFactory.openSession();
		session.save(user);
		session.close();
	}

	public User getUserById(String userId) {
		Session session = sFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

}
