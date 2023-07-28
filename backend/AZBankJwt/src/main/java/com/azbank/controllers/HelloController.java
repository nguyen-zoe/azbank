package com.azbank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this to check if 
@RestController
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		return ResponseEntity.ok().body("Hello from JWT Authorization");
	}
}
