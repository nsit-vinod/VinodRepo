package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

}
