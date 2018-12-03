package com.ipark.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ipark.rest.webservices.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id) {
		User user = service.findOne(id);
		if(null==user) {
			throw new UserNotFoundException("id-"+id);
		}
		
		Resource<User> resource = new Resource<>(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder
				        .fromCurrentRequest().path("/{id}")
				          .buildAndExpand(savedUser.getId())
				         .toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public User deleteUser(@PathVariable Integer id) {
		User  user = service.deleteById(id);
		if(null==user) {
			throw new UserNotFoundException("id-"+id);
		}
		
		return user;
	}
}
