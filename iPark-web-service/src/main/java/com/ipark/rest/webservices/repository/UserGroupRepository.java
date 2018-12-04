package com.ipark.rest.webservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipark.rest.webservices.model.User;
import com.ipark.rest.webservices.model.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {

	List<UserGroup> findByUser(User user);

}
