package com.azbank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azbank.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

	
	List<Transaction> findByAccountId(Integer accountId);
}
