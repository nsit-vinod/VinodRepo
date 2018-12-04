package com.ipark.rest.webservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.ParkingArea;
import com.ipark.rest.webservices.model.Slots;

public interface SlotsRepository extends JpaRepository<Slots, Integer> {

	List<Slots> findByParkingArea(ParkingArea parkingArea);

}
