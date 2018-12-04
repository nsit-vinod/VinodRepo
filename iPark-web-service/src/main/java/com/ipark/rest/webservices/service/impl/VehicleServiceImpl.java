package com.ipark.rest.webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipark.rest.webservices.exception.UserNotFoundException;
import com.ipark.rest.webservices.exception.VehicleNotFoundException;
import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.Vehicle;
import com.ipark.rest.webservices.repository.UserRepository;
import com.ipark.rest.webservices.repository.VehicleRepository;
import com.ipark.rest.webservices.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return vehicleRepository.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle, Long vehicleId) {
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
		if(!vehicleOptional.isPresent()) {
			throw new VehicleNotFoundException("Vehicle is not available");
		}
		Vehicle existedVehicle = vehicleOptional.get();
		existedVehicle.setVehicleCategory(vehicle.getVehicleCategory());
		existedVehicle.setVehicleRegistrationNumber(vehicle.getVehicleRegistrationNumber());
		return vehicleRepository.save(existedVehicle);
	}

	@Override
	public List<Vehicle> findVehicleByUser(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent()) {
			throw new VehicleNotFoundException("Vehicle is not available");
		}
		List<Vehicle> vehicleList = vehicleRepository.findByUser(userOptional.get());
		return vehicleList;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle getVehicleById(Long vehicleId) {
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
		if(!vehicleOptional.isPresent()) {
			throw new VehicleNotFoundException("Vehicle is not available");
		}
		return vehicleOptional.get();
	}

	@Override
	public void deleteVehicle(Long vehicleId) {
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleId);
		if(!vehicleOptional.isPresent()) {
			throw new VehicleNotFoundException("Vehicle is not available");
		}
		vehicleRepository.delete(vehicleOptional.get());
	}

}
