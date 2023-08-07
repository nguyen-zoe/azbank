package com.azbank.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.azbank.entity.Account;

@FeignClient(name = "accounts", url="${application.config.accounts-url}")
public interface AccountClient {

	//proxy open feign will establish the implement in AccountController
	
	@GetMapping("{customerId}")
	List<Account> findAllAccountsByCustomer(@PathVariable("customerId") Integer id);
}
