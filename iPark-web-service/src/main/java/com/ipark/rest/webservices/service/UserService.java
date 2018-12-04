package com.ipark.rest.webservices.service;

import java.util.List;

import com.ipark.rest.webservices.model.User;

public interface UserService {

	
	public User createUser(User user);
	
	public User getUserById(Long userId);
	
	public User updateUser(User user, Long userId);
	
	public void deleteUser(Long userId);
	
	public List<User> findAllUsers();

	public String changePassword(Long userId, String password);
	
	
}
