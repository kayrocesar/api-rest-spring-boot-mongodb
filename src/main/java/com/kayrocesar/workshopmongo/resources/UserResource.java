package com.kayrocesar.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kayrocesar.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// @RequestMapping(method=RequestMethod.GET)
	@GetMapping
	// public List<User> findAll(){
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Santos", "mariasantos@gmail.com");
		User jose = new User("2", "Jose Cesar", "jose.cesar@gmail.com");
		return ResponseEntity.ok().body(Arrays.asList(maria, jose));
	}

}
