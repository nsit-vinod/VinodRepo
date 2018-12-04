package com.ipark.rest.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipark.rest.webservices.model.Slots;
import com.ipark.rest.webservices.service.ParkingSlotsService;

@RestController
public class ParkingSlotsController {

	@Autowired
	private ParkingSlotsService parkingSlotsService;
	
	@PostMapping(path="/slots")
	public Slots createSlot(@RequestBody Slots slots) {
		// TODO Auto-generated method stub
		return parkingSlotsService.createSlot(slots);
	}

	@PutMapping(path="/slots/{slotId}")
	public Slots updateSlots(@RequestBody Slots slots,@PathVariable("slotId") Integer slotId) {
		// TODO Auto-generated method stub
		return parkingSlotsService.updateSlots(slots, slotId);
	}

	@GetMapping(path="/slots",params = {"parkingAreaId"} )
	public List<Slots> findSlotsByParkingArea(@RequestParam("parkingAreaId") Long parkingAreaId) {
		// TODO Auto-generated method stub
		return parkingSlotsService.findSlotsByParkingArea(parkingAreaId);
	}

	@GetMapping(path="/available-slots")
	public List<Slots> findAllAvailableSlots() {
		// TODO Auto-generated method stub
		return parkingSlotsService.findAllAvailableSlots();
	}

}
