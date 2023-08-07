package com.azbank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azbank.dto.FullAccountResponse;
import com.azbank.entiry.Account;
import com.azbank.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	
	private final AccountService service;
	
	@GetMapping
	public ResponseEntity<List<Account>> findAllAccounts(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody Account account) {
		service.save(account);
	}
	
	@PutMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Account a) {
		service.update(a);
	}
	
	@DeleteMapping(value = "/id", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
	
	@GetMapping("{customerId}")
	public ResponseEntity<List<Account>> findAllAccounts(@PathVariable("customerId") Integer id){
		return ResponseEntity.ok(service.findAllAccountsByCustomer(id));
	}
	
	@GetMapping("/with-transaction/{accountId")
	public ResponseEntity<FullAccountResponse> findAllTransactionsbyAccount(@PathVariable("accountId") Integer accountId){
		return ResponseEntity.ok(service.findAccountWithTransactions(accountId));
	}
	
}
