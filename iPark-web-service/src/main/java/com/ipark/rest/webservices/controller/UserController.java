package com.ipark.rest.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path="/user")
	public User createUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		return userService.createUser(user);
	}

	@PostMapping(path="/change-password/{userId}/{password}")
	public String changePassword(@PathVariable("userId") Long userId,@PathVariable("password") String password) {
		return userService.changePassword(userId, password);
	}
	@GetMapping(path="/user/{userId}")
	public User getUserById(@PathVariable("userId") Long userId) {
		// TODO Auto-generated method stub
		return userService.getUserById(userId);
	}

	@PutMapping(path="/user/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable("userId") Long userId) {
		// TODO Auto-generated method stub
		return userService.updateUser(user, userId);
	}

	@DeleteMapping(path="/user/{userId}")
	public void deleteUser(@PathVariable("userId")Long userId) {
		userService.deleteUser(userId);

	}

	@GetMapping(path="/user")
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userService.findAllUsers();
	}
	
	@GetMapping(path="/user/vehicle", params= {"vehicleRegistrationNumberId"})
	public User getUserByVehicleRegistrationNumber(@RequestParam("vehicleRegistrationNumber") String vehicleRegistrationNumber) {
		
		return userService.getUserByVehicleRegistrationNumber(vehicleRegistrationNumber);
	}

}
