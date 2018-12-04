package com.ipark.rest.webservices.service;

import java.util.List;

import com.ipark.rest.webservices.model.ParkingArea;

public interface ParkingAreaService {

	public ParkingArea createParkingArea(ParkingArea parkingArea);
	
	public ParkingArea updateParkingArea(ParkingArea parkingArea, Long areaId);
	
	public ParkingArea findByParkingAreaName(String parkingAreaName);
	
	public List<ParkingArea> getAllParkingAreas();
	
	public ParkingArea findParkingAreaById(Long areaId);
	
}
