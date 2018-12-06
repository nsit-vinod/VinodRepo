package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.Parking;
import com.ipark.rest.webservices.model.Vehicle;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

	Parking findByVehicleAndOutTime(Vehicle vehicle, String outTime);

}
