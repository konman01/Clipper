package com.konman.clipper.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.konman.clipper.dao.UserRepository;
import com.konman.clipper.entity.User;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	// Autowiring the UserRepository Object
	@Autowired
	private UserRepository userRepository;

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

	// Service to fetch the user based on UserId
	@Override
	public User findUserById(int userId) {
		
		Optional<User> optionUser = userRepository.findById(userId);
		
		// If the User is Not present then throw the User Not Found Exception
		if(!optionUser.isPresent()) {
			throw new UserNotFoundException("User Not found with is:"+userId);
		}
		
		return optionUser.get();
	}
	
	// Service to update the User Details
	@Override
	public User updateUser(User theUser) {
		
		// first get the user from the DB with the User Id
		Optional<User> currentUserOptional = userRepository.findById(theUser.getId());
		
		// If the user is not present in the database, then throw EWxception
		if(!currentUserOptional.isPresent()) {
			throw new UserNotFoundException("User not found with User Id:"+theUser.getId());
		}
		
		// Save the user
		User theDbUser = userRepository.save(theUser);
		
		return theDbUser;
	}
	
	// End Point to delete a User
	@Override
	public void deleteUser(int userId) {
		
		// first get the user from the DB with the User Id
		Optional<User> currentUserOptional = userRepository.findById(userId);
		
		// If the user is not present in the database, then throw EWxception
		if(!currentUserOptional.isPresent()) {
			throw new UserNotFoundException("User not found with User Id:"+userId);
		}		
		
		// Delete the User By User Id
		userRepository.deleteById(userId);
				
		return;
	}
	

}
