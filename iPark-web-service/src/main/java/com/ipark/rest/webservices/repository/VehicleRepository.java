package com.ipark.rest.webservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByUser(User user);

}
