package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.VehicleCategory;

public interface VechileCategoryRepository extends JpaRepository<VehicleCategory, Integer> {

}
