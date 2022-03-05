package com.konman.clipper.service;


import com.konman.clipper.dto.UserDTO;
import com.konman.clipper.entity.User;
import com.konman.clipper.model.UserVO;

public interface UserService {
	
	public UserDTO saveUser(UserVO theUserVO);
	
	public UserDTO findUserById(int userId);
	
	public UserDTO updateUser(UserVO theUserVO);
	
	public void deleteUser(int userId);

	public UserDTO findUserByEmail(String email);

}
