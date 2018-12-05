package com.ipark.rest.webservices.service;

import java.util.List;

import com.ipark.rest.webservices.model.Vehicle;

public interface VehicleService {

	public Vehicle createVehicle(Vehicle vehicle);
	
	public Vehicle updateVehicle(Vehicle vehicle, Long vehicleId);
	
	public List<Vehicle> findVehicleByUser(Long userId);
	
	public List<Vehicle> getAllVehicle();
	
	public Vehicle getVehicleById(Long vehicleId);

	public void deleteVehicle(Long vehicleId);

	Vehicle getVehicleByRegistrationNumber(String vehicleRegistrationNumber);
	
}
