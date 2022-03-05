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
import com.konman.clipper.dto.UserDTO;
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
	
	@Autowired
	private Gson gson;
	
	// End point to save the clipper user
	@PostMapping("/users")
	public UserDTO saveUser(@RequestBody UserVO theUserVO) {

		ClipperUtility.clipperLogger.info("Started to load User into database");
		UserDTO dbUser = userService.saveUser(theUserVO);
		ClipperUtility.clipperLogger.info("Loaded the user with Id:"+dbUser.getId());
		return dbUser;
		//return null;
	}
	
	// End point to get the User based on User Id
	@GetMapping("/users/{userId}")
	public UserDTO findUserById(@PathVariable int userId) {
		ClipperUtility.clipperLogger.info("Fetching the User with user Id: "+userId);
		UserDTO theUserDto = userService.findUserById(userId);
		
		return theUserDto;
		
	}// End of function
	
	// End point to update the User and Contact Details
	@PutMapping("/users")
	public UserDTO updateUser(@RequestBody UserVO theUserVO) {
		
		ClipperUtility.clipperLogger.info("Updating the user with UserId:"+theUserVO.getId());
		
		UserDTO theDbUser = userService.updateUser(theUserVO);
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
	public UserDTO getUserByEmail(@RequestParam String email) {
		ClipperUtility.clipperLogger.info("Fetching the use with email:"+email);
		UserDTO userDto = userService.findUserByEmail(email);
		return userDto;
		
	}
	
	
}// End of the class
