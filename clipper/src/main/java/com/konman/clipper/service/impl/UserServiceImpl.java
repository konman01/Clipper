package com.konman.clipper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.entity.User;
import com.konman.clipper.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	// Service to get All the Clipper users
	@Override
	public List<User> findUsers() {
		return userRepository.findAll();
	}

	// Service to save an user into Clipper DB
	@Override
	public User saveUser(User theUser) {
		
		User dbUser = userRepository.save(theUser);
		
		return dbUser;
		
	}

}
