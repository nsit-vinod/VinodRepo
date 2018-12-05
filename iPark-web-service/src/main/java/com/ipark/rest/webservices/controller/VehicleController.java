package com.ipark.rest.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.Vehicle;
import com.ipark.rest.webservices.service.VehicleService;

@RestController
public class VehicleController {


	@Autowired
    private VehicleService vehicleService;
	
	@PostMapping(path="/vehicle")
	public Vehicle createVehicle(Vehicle vehicle) {
		
		return vehicleService.createVehicle(vehicle);
	}

	@PutMapping(path="/vehicle/{vehicleId}")
	public Vehicle updateVehicle(Vehicle vehicle, Long vehicleId) {
		
		return vehicleService.updateVehicle(vehicle, vehicleId);
	}

	@GetMapping(path="/vehicle/user",params = {"userId"} )
	public List<Vehicle> findVehicleByUser(Long userId) {
		
		return vehicleService.findVehicleByUser(userId);
	}

	@GetMapping(path="/vehicle")
	public List<Vehicle> getAllVehicle() {
		
		return vehicleService.getAllVehicle();
	}

	@GetMapping(path="/vehicle/{vehicleId}")
	public Vehicle getVehicleById(Long vehicleId) {
		
		return vehicleService.getVehicleById(vehicleId);
	}
	@DeleteMapping(path="/vehicle/{vehicleId}")
	public void deleteUser(@PathVariable("vehicleId")Long vehicleId) {
		vehicleService.deleteVehicle(vehicleId);

	}

}
