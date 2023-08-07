package com.azbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.azbank.entity.Transaction;
import com.azbank.repo.TransactionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

	private final TransactionRepo repo;
	
	public List<Transaction> findAll(){
		return repo.findAll();
	}
	
	public void save(Transaction transaction) {
		repo.save(transaction);
	}
	
	public void update(Transaction transaction) {
		repo.saveAndFlush(transaction);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Transaction> findAllByAccount(Integer accountId){
		return repo.findByAccountId(accountId);
	}
}
