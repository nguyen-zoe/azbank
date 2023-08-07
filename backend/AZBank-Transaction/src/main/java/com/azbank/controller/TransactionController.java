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

import com.azbank.entity.Transaction;
import com.azbank.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService service;
	
	@GetMapping
	public ResponseEntity<List<Transaction>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Transaction transaction) {
		service.save(transaction);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Transaction transaction) {
		service.save(transaction);
	}
	@DeleteMapping(value = "/id", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
	
	@GetMapping("/accounts/{accoundId")
	public ResponseEntity<List<Transaction>> findAllByAccountId(@PathVariable("accountId") Integer id){
		return ResponseEntity.ok(service.findAllByAccount(id));
	}
	
}
