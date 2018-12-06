package com.ipark.rest.webservices.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipark.rest.webservices.exception.UserNotFoundException;
import com.ipark.rest.webservices.model.Parking;
import com.ipark.rest.webservices.model.ParkingArea;
import com.ipark.rest.webservices.model.Slots;
import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.Vehicle;
import com.ipark.rest.webservices.repository.ParkingRepository;
import com.ipark.rest.webservices.repository.SlotsRepository;
import com.ipark.rest.webservices.repository.VehicleRepository;
import com.ipark.rest.webservices.service.UserService;

@RestController
public class ParkingAllocationDeAllocationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SlotsRepository slotsRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private ParkingRepository parkingRepository;
/*	API 1: Block parking for incoming car and send parking details to user.
	API input: car registration no
	Functionality:
	check car registration no in vehicle table, find the user id for that vehicle.
	Based on the userid get user details form users table.
	get the 'preferred_parking_area' column and allocate(update in_time and vechile_id) one parking in parking table where parking_area_id is equal to preferred_parking_area.
	Once the record is update in parking table return below details:
	Return from API: parking_no,longitude,latitude from parking and device_id,arn,emp_id from users table.*/
	
	@PostMapping(path="/api/parking/allocation-deallocation", params= {"vehicleRegistrationNumber"})
	public Parking getParkingDetails(@RequestParam("vehicleRegistrationNumber") String vehicleRegistrationNumber) {
		
		User user = userService.getUserByVehicleRegistrationNumber(vehicleRegistrationNumber);
		
		Vehicle vehicle = vehicleRepository.findByVehicleRegistrationNumber(vehicleRegistrationNumber);
		
		Parking parkingDetails = parkingRepository.findByVehicleAndOutTime(vehicle,null);
		
		String pattern = "dd-MMM-yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String currentDate = simpleDateFormat.format(new Date());
		System.out.println(currentDate);
		
		if(null != parkingDetails) {
		    Date outDate;
			try {
				 outDate = simpleDateFormat.parse(currentDate);
				 Date inDate = simpleDateFormat.parse(parkingDetails.getInTime());
				 long diff = outDate.getTime() - inDate.getTime();
				 
				 long diffMinutes = diff / (60 * 1000) % 60;
				 if(diffMinutes<5) {
					 return parkingDetails;
				 }
				 
				 else {
					 return vacantParkingSlot(parkingDetails);
				 }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(user==null) {
			throw new UserNotFoundException("User not available");
		}
		
		ParkingArea parkingArea = user.getParkingArea();
		List<Slots> slots = slotsRepository.findByParkingAreaAndActive(parkingArea,1); //1 is empty and 2 is full
		Parking parking = null;
		if(!slots.isEmpty()) {
			Slots slot = slots.get(0);
			
			parking = new Parking();
			parking.setInTime(currentDate);
			parking.setPaidStatus(2);
			parking.setParkingCode(slot.getSlotName());
			parking.setSlot(slot);
			parking.setVehicleCategory(vehicle.getVehicleCategory());
			parking.setVehicle(vehicle);
			parking = parkingRepository.save(parking);
		}
		
		else {
			List<Slots> emptySlots = slotsRepository.findByActive(1);
			
			if(!emptySlots.isEmpty()) {
				Slots slot = slots.get(0);
				slot.setActive(2);
				slot = slotsRepository.save(slot);
				parking = new Parking();
				parking.setInTime(currentDate);
				parking.setPaidStatus(2);
				parking.setParkingCode(slot.getSlotName());
				parking.setSlot(slot);
				parking.setVehicleCategory(vehicle.getVehicleCategory());
				parking.setVehicle(vehicle);
				parking = parkingRepository.save(parking);
			}
		}
		return parking;
		
	}
	
	public Parking vacantParkingSlot(Parking parking) {
		
		
		Slots slot = parking.getSlot();
		slot.setActive(1);
		slot = slotsRepository.save(slot);
		parking.setOutTime(new Date().toString());
		parking.setPaidStatus(2);
		//Get diff between two date
		String pattern = "dd-MMM-yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String currentDate = simpleDateFormat.format(new Date());
		System.out.println(currentDate);
	    Date outDate;
		try {
			 outDate = simpleDateFormat.parse(currentDate);
			 Date inDate = simpleDateFormat.parse(parking.getInTime());
			 long diff = outDate.getTime() - inDate.getTime();
				parking.setTotalTime(diff);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
		parking = parkingRepository.save(parking);
	    
	  
		return parking;
	}
}
