package com.azbank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azbank.entity.Customer;
import com.azbank.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Customer customer) {
		service.saveCustomer(customer);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Customer customer) {
		service.update(customer);
	}
	
	@DeleteMapping(value = "/id", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
}
