package com.konman.clipper.usercontroller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konman.clipper.entity.Contact;
import com.konman.clipper.entity.User;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.ClipperUtility;
import com.konman.clipper.utility.UserNotFoundException;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	// Autowiring the userService
	@Autowired
	UserService userService;
	
	/*
	 * private User user; private Contact contact;
	 * 
	 * @PostConstruct public void loadData() {
	 * 
	 * user = new User("Manjunatha", "Koni Gururaja",
	 * "manjunatha.konigururaja@gmail.com", "6692104716"); contact = new
	 * Contact("3100 Ohio Drive", null, "Frisco", "Texas", "75035");
	 * user.setContact_detail(contact);
	 * 
	 * 
	 * }
	 */
	
	
	// End point to get all the Clipper Users
	@GetMapping("/users")
	public List<User> findUsers(){
		ClipperUtility.clipperLogger.info("Fetching all the Users");
		ClipperUtility.clipperLogger.info("/users");
		return userService.findUsers();
	}
	
	// End point to save the clipper user
	@PostMapping("/users")
	public User saveUser(@RequestBody User theUser) {
		
		ClipperUtility.clipperLogger.info("Started to load User into database");
		User dbUser = userService.saveUser(theUser);
		ClipperUtility.clipperLogger.info("Loaded the user with Id:"+dbUser.getId());
		return dbUser;
	}
	
	// End point to get the User based on User Id
	@GetMapping("/users/{userId}")
	public User findUserById(@PathVariable int userId) {
		ClipperUtility.clipperLogger.info("Fetching the User with user Id: "+userId);
		
		User theUser = userService.findUserById(userId);
		
		return theUser;
	}
	
}