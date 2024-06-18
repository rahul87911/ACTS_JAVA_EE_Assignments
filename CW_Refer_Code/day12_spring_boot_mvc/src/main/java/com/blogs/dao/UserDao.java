package com.blogs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
	//for sign in
	Optional<User> findByEmailAndPassword(String em,String pass);

}
