package com.ipark.rest.webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipark.rest.webservices.exception.VehicleNotFoundException;
import com.ipark.rest.webservices.model.ParkingArea;
import com.ipark.rest.webservices.repository.ParkingAreaRepository;
import com.ipark.rest.webservices.service.ParkingAreaService;

@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {

	@Autowired
	private ParkingAreaRepository parkingAreaRepository;
	@Override
	public ParkingArea createParkingArea(ParkingArea parkingArea) {
		// TODO Auto-generated method stub
		return parkingAreaRepository.save(parkingArea);
	}

	@Override
	public ParkingArea updateParkingArea(ParkingArea parkingArea, Long areaId) {
		Optional<ParkingArea> areaOptional = parkingAreaRepository.findById(areaId);
		if(areaOptional.isPresent()) {
			throw new VehicleNotFoundException("Paring area is not available");
		}
		ParkingArea existParkingArea = areaOptional.get();
		existParkingArea.setParkingAreaName(parkingArea.getParkingAreaName());
		return parkingAreaRepository.save(existParkingArea);
	}

	@Override
	public ParkingArea findByParkingAreaName(String parkingAreaName) {
		// TODO Auto-generated method stub
		return parkingAreaRepository.findByParkingAreaName(parkingAreaName);
	}

	@Override
	public List<ParkingArea> getAllParkingAreas() {
		// TODO Auto-generated method stub
		return parkingAreaRepository.findAll();
	}

	@Override
	public ParkingArea findParkingAreaById(Long areaId) {
		Optional<ParkingArea> areaOptional = parkingAreaRepository.findById(areaId);
		if(areaOptional.isPresent()) {
			throw new VehicleNotFoundException("Paring area is not available");
		}
		return areaOptional.get();
	}

}
