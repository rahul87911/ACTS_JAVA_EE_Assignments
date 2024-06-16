package com.blogs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.AuthenticationException;
import com.blogs.dao.UserDao;
import com.blogs.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	// depcy : user dao i/f
	@Autowired
	private UserDao userDao;

	@Override
	public User signIn(String email, String password) {
		Optional<User> optional = 
				userDao.findByEmailAndPassword(email, password);
		return optional.orElseThrow(() ->
		new AuthenticationException("Invalid email or password !!!!!"));
	}

}
