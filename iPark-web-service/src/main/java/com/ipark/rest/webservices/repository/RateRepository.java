package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.Rate;

public interface RateRepository extends JpaRepository<Rate, Integer> {

}
