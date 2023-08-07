package com.azbank.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.azbank.entiry.Transaction;

@Component
@FeignClient(name = "transactions", url = "${application.config.transaction-url}")
public interface TransactionClient {

	@GetMapping("{accountId")
	List<Transaction> findAllbyAccount(@PathVariable("accountId") Integer id);
}
