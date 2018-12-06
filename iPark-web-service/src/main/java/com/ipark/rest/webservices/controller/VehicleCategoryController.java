package com.ipark.rest.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipark.rest.webservices.model.VehicleCategory;
import com.ipark.rest.webservices.service.VehicleCategoryService;

@RestController
public class VehicleCategoryController {


	@Autowired
	private VehicleCategoryService vehicleCategoryService;

	@GetMapping(path="/vehicle-category")
	public List<VehicleCategory> getAllVehicleCategory() {
		// TODO Auto-generated method stub
		return vehicleCategoryService.getAllVehicleCategory();
	}

	@PostMapping(path="/vehicle-category")
	public VehicleCategory createVehicleCategory(@RequestBody VehicleCategory vehicleCategory) {
		// TODO Auto-generated method stub
		return vehicleCategoryService.createVehicleCategory(vehicleCategory);
	}

	@PutMapping(path="/vehicle-category")
	public VehicleCategory updateVehicleCategory(@RequestBody VehicleCategory vehicleCategory) {
		// TODO Auto-generated method stub
		return vehicleCategoryService.updateVehicleCategory(vehicleCategory);
	}

	@GetMapping(path="/vehicle-category/{id}")
	public VehicleCategory findById(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		return vehicleCategoryService.findById(id);
	}

	@DeleteMapping(path="/vehicle-category/{id}")
	public void deleteVehicleCategory(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		vehicleCategoryService.deleteVehicleCategory(id);
	}


}
