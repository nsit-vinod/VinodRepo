package com.ipark.rest.webservices.service;

import java.util.List;

import com.ipark.rest.webservices.model.Slots;

public interface ParkingSlotsService {

	
	public Slots createSlot(Slots slots);
	
	public Slots updateSlots(Slots slots, Integer slotId);
	
	public List<Slots> findSlotsByParkingArea(Long parkingAreaId);
	
	public List<Slots> findAllAvailableSlots();
}
