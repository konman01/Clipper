package com.konman.clipper.usercontroller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.konman.clipper.entity.User;
import com.konman.clipper.model.UserVO;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.ClipperUtility;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	// Autowiring the userService
	@Autowired
	private UserService userService;
	
	// Autowiring the Model Mapper
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Gson gson;
	
	
	// End point to get all the Clipper Users
	@GetMapping("/users")
	public List<User> findUsers(){
		ClipperUtility.clipperLogger.info("Fetching all the Users");
		ClipperUtility.clipperLogger.info("/users");
		return userService.findUsers();
	}
	
	// End point to save the clipper user
	@PostMapping("/users")
	public User saveUser(@RequestBody UserVO theUserJson) {
		
		modelMapper.typeMap(UserVO.class, User.class).addMappings(mapper -> {
			mapper.map(UserVO::getContactCreateJson,User::setContactDetail);
		});
		
		
		User user = modelMapper.map(theUserJson, User.class);
		
		ClipperUtility.clipperLogger.info("Started to load User into database");
		User dbUser = userService.saveUser(user);
		ClipperUtility.clipperLogger.info("Loaded the user with Id:"+dbUser.getId());
		return dbUser;
		//return null;
	}
	
	// End point to get the User based on User Id
	@GetMapping("/users/{userId}")
	public User findUserById(@PathVariable int userId) {
		ClipperUtility.clipperLogger.info("Fetching the User with user Id: "+userId);
		
		User theUser = userService.findUserById(userId);
		
		return theUser;
		
	}// End of function
	
	// End point to update the User and Contact Details
	@PutMapping("/users")
	public User updateUser(@RequestBody UserVO theUserJson) {
		
		ClipperUtility.clipperLogger.info("Updating the user with UserId:"+theUserJson.getId());
		
		System.out.println(theUserJson);
		
		modelMapper.typeMap(UserVO.class, User.class).addMappings(mapper -> {
			mapper.map(UserVO::getContactCreateJson,User::setContactDetail);
		});
		
		
		User user = modelMapper.map(theUserJson, User.class);
		
		User theDbUser = userService.updateUser(user);
		
		return theDbUser;
		
	}
	
	// End point to delete the User Based on User Id
	@DeleteMapping("/users/{userId}")
	public String deleteUserByUserId(@PathVariable int userId) {
		
		Map<String, String> responseMap = new LinkedHashMap<>();
		
		userService.deleteUser(userId);
		responseMap.put("status", "sucess");
		responseMap.put("message", "Deleted Clipper user with id:"+userId);
		ClipperUtility.clipperLogger.info("Deleting the user with user Id:"+userId);
		return gson.toJson(responseMap);
	}
	
	// End Point to get the User based on the Email Address
	@GetMapping("/users/email")
	public User getUserByEmail(@RequestParam String email) {
		
		ClipperUtility.clipperLogger.info("Fetching the use with email:"+email);
		User user = userService.findUserByEmail(email);
		
		return user;
		
	}
	
	
}// End of the class
