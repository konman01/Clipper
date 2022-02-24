package com.konman.clipper.usercontroller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.konman.clipper.entity.Contact;
import com.konman.clipper.entity.User;
import com.konman.clipper.service.UserService;
import com.konman.clipper.utility.ClipperUtility;

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
		
		ClipperUtility.clipperLogger.info("/users");
		return userService.findUsers();
	}
	
	// End point to save the clipper user
	@PostMapping("/users")
	public User saveUser(@RequestBody User theUser) {
		
		ClipperUtility.clipperLogger.info("Started to load data into database");
		User dbUser = userService.saveUser(theUser);
		return dbUser;
	}
}
