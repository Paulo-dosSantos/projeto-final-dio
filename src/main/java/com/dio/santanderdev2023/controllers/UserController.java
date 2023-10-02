package com.dio.santanderdev2023.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio.santanderdev2023.domain.model.User;
import com.dio.santanderdev2023.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User>findById(@PathVariable Long id){
		User user= service.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	@PostMapping
	public ResponseEntity<User>create(@RequestBody User obj){
		var userCreated=service.create(obj);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(userCreated.getId()).toUri();
		
		return ResponseEntity.created(location).body(userCreated);
	}

}
