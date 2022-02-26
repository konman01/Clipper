package com.konman.clipper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.konman.clipper.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByEmail(String name);

}
