package com.blogs.service;

import com.blogs.entities.User;

public interface UserService {
	User signIn(String email, String password);
}
