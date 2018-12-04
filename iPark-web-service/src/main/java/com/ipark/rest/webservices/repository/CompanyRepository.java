package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
