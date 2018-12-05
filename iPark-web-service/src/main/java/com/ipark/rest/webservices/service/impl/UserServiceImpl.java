package com.ipark.rest.webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipark.rest.webservices.exception.UserNotFoundException;
import com.ipark.rest.webservices.exception.VehicleNotFoundException;
import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.Vehicle;
import com.ipark.rest.webservices.repository.UserRepository;
import com.ipark.rest.webservices.service.UserService;
import com.ipark.rest.webservices.service.VehicleService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VehicleService vehicleService;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		bCryptPasswordEncoder.encode(user.getPassword());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not available");
		}
		return userOptional.get();
	}

	@Override
	public User updateUser(User user, Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not available");
		}
		
		User existingUser = userOptional.get();
		existingUser.setArn(user.getArn());
		existingUser.setDeviceId(user.getDeviceId());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setGender(user.getGender());
		existingUser.setIsAdmin(user.getIsAdmin());
		existingUser.setLastName(user.getLastName());
		existingUser.setPhone(user.getPhone());
		existingUser.setParkingArea(user.getParkingArea());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not available");
		}
		userRepository.deleteById(userId);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public String changePassword(Long userId, String password) {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User is not available");
		}
		User existingUser = userOptional.get();
		existingUser.setPassword(bCryptPasswordEncoder.encode(password));
		userRepository.save(existingUser);
		return "Password updated successfully.";
	}

	@Override
	public User getUserByVehicleRegistrationNumber(String vehicleRegistrationNumber) {
	Vehicle vehicle =	vehicleService.getVehicleByRegistrationNumber(vehicleRegistrationNumber);
		
	return vehicle.getUser();
	}

}
