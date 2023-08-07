package com.azbank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azbank.entiry.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

	//find all accounts by customerId
	
	List<Account> findByCustomerId(Integer customerId);
}
