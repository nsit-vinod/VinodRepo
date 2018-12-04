package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.Groups;

public interface GroupsRepository extends JpaRepository<Groups, Integer> {

}
