package com.ipark.rest.webservices.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipark.rest.webservices.exception.VehicleNotFoundException;
import com.ipark.rest.webservices.model.ParkingArea;
import com.ipark.rest.webservices.model.Slots;
import com.ipark.rest.webservices.repository.ParkingAreaRepository;
import com.ipark.rest.webservices.repository.SlotsRepository;
import com.ipark.rest.webservices.service.ParkingSlotsService;

@Service
public class ParkingSlotsServiceImpl implements ParkingSlotsService {

	@Autowired
	private SlotsRepository slotsRepository;
	
	@Autowired
	private ParkingAreaRepository parkingAreaRepository;
	@Override
	public Slots createSlot(Slots slots) {
		// TODO Auto-generated method stub
		return slotsRepository.save(slots);
	}

	@Override
	public Slots updateSlots(Slots slots, Integer slotId) {
		Optional<Slots> slotsOptional = slotsRepository.findById(slotId);
		if(!slotsOptional.isPresent()) {
			throw new VehicleNotFoundException("Slots is not available");
		}
		
		Slots existedSlot = slotsOptional.get();
		existedSlot.setActive(slots.getActive());
		existedSlot.setAvailabilityStatus(slots.getAvailabilityStatus());
		existedSlot.setDistanceFromBuilding(slots.getDistanceFromBuilding());
		existedSlot.setIsReservedParking(slots.getIsReservedParking());
		existedSlot.setIsSmallParking(slots.getIsSmallParking());
		existedSlot.setIsVisitorParking(slots.getIsVisitorParking());
		existedSlot.setLatitude(slots.getLatitude());
		existedSlot.setLongitude(slots.getLongitude());
		existedSlot.setParkingArea(slots.getParkingArea());
		existedSlot.setSlotName(slots.getSlotName());
		
		return slotsRepository.save(existedSlot);
	}

	@Override
	public List<Slots> findSlotsByParkingArea(Long parkingAreaId) {
		Optional<ParkingArea> areaOptional = parkingAreaRepository.findById(parkingAreaId);
		if(!areaOptional.isPresent()) {
			throw new VehicleNotFoundException("Parking area is not available");
		}
		return slotsRepository.findByParkingArea(areaOptional.get());
	}

	@Override
	public List<Slots> findAllAvailableSlots() {
		// TODO Auto-generated method stub
		return null;
	}

}
