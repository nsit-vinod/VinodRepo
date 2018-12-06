package com.ipark.rest.webservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipark.rest.webservices.model.VehicleCategory;
import com.ipark.rest.webservices.repository.VechileCategoryRepository;
import com.ipark.rest.webservices.service.VehicleCategoryService;

@Service
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

	@Autowired
	private VechileCategoryRepository vehicleCategoryRepository;
	@Override
	public List<VehicleCategory> getAllVehicleCategory() {
		// TODO Auto-generated method stub
		return vehicleCategoryRepository.findAll();
	}

	@Override
	public VehicleCategory createVehicleCategory(VehicleCategory vehicleCategory) {
		// TODO Auto-generated method stub
		return vehicleCategoryRepository.save(vehicleCategory);
	}

	@Override
	public VehicleCategory updateVehicleCategory(VehicleCategory vehicleCategory) {
		// TODO Auto-generated method stub
		return vehicleCategoryRepository.save(vehicleCategory);
	}

	@Override
	public VehicleCategory findById(Integer id) {
		// TODO Auto-generated method stub
		return vehicleCategoryRepository.getOne(id);
	}

	@Override
	public void deleteVehicleCategory(Integer id) {
		vehicleCategoryRepository.deleteById(id);

	}

}
