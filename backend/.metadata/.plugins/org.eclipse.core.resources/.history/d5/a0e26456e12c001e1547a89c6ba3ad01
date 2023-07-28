package com.azbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azbank.dtos.SignupRequest;
import com.azbank.dtos.UserDTO;
import com.azbank.services.AuthService;

@RestController
public class SignupUserController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody SignupRequest singupRequest){
		
		UserDTO createdUser = authService.createUser(singupRequest);
		
		if(createdUser ==null) {
			return new ResponseEntity<> ("User is not created, try again later", HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
}
