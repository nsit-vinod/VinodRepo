package com.ipark.rest.webservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.ParkingArea;
import com.ipark.rest.webservices.model.Slots;

public interface SlotsRepository extends JpaRepository<Slots, Integer> {

	List<Slots> findByParkingArea(ParkingArea parkingArea);

	List<Slots> findByParkingAreaAndActive(ParkingArea parkingArea, int i);

	List<Slots> findByActive(int i);

}
