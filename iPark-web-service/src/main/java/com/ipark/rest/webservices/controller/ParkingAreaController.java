package com.ipark.rest.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipark.rest.webservices.model.ParkingArea;
import com.ipark.rest.webservices.service.ParkingAreaService;

@RestController
public class ParkingAreaController {


	@Autowired
	private ParkingAreaService parkingAreaService;
	
	@PostMapping(path="/parking-area")
	public ParkingArea createParkingArea(@RequestBody ParkingArea parkingArea) {
		// TODO Auto-generated method stub
		return parkingAreaService.createParkingArea(parkingArea);
	}

	@PutMapping(path="/parking-area/{areaId}")
	public ParkingArea updateParkingArea(@RequestBody ParkingArea parkingArea, @PathVariable("areaId") Long areaId) {
		// TODO Auto-generated method stub
		return parkingAreaService.updateParkingArea(parkingArea, areaId);
	}

	@GetMapping(path="/parking-area/{parkingAreaId}")
	public ParkingArea findByParkingAreaName(@PathVariable("parkingAreaName") String parkingAreaName) {
		// TODO Auto-generated method stub
		return parkingAreaService.findByParkingAreaName(parkingAreaName);
	}

	@GetMapping(path="/parking-area")
	public List<ParkingArea> getAllParkingAreas() {
		// TODO Auto-generated method stub
		return parkingAreaService.getAllParkingAreas();
	}

	@GetMapping(path="/parking-area/{areaId}")
	public ParkingArea findParkingAreaById(@PathVariable("areaId") Long areaId) {
		// TODO Auto-generated method stub
		return parkingAreaService.findParkingAreaById(areaId);
	}


}
