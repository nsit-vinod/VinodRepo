package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.ParkingArea;

public interface ParkingAreaRepository extends JpaRepository<ParkingArea, Long> {

	ParkingArea findByParkingAreaName(String parkingAreaName);

}
