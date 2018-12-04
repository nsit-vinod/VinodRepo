package com.ipark.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String username);

}
