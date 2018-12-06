package com.ipark.rest.webservices.service;

import java.util.List;

import com.ipark.rest.webservices.model.VehicleCategory;

public interface VehicleCategoryService {

	public List<VehicleCategory> getAllVehicleCategory();
	
	public VehicleCategory createVehicleCategory(VehicleCategory vehicleCategory);
	
	public VehicleCategory updateVehicleCategory(VehicleCategory vehicleCategory);
	
	public VehicleCategory findById(Integer id);
	
	public void deleteVehicleCategory(Integer id);
}
