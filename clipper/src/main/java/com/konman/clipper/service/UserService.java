package com.konman.clipper.service;

import java.util.List;

import com.konman.clipper.dto.UserDTO;
import com.konman.clipper.entity.User;
import com.konman.clipper.model.UserVO;

public interface UserService {
	
	public List<UserDTO> findUsers();
	
	public User saveUser(UserVO theUserVO);
	
	public User findUserById(int userId);
	
	public User updateUser(UserVO theUserVO);
	
	public void deleteUser(int userId);

	public User findUserByEmail(String email);

}
