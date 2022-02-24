package com.konman.clipper.service;

import java.util.List;

import com.konman.clipper.entity.User;

public interface UserService {
	
	public List<User> findUsers();
	
	public User saveUser(User theUser);

}
