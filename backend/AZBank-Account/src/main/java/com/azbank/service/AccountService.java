package com.azbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.azbank.dto.FullAccountResponse;
import com.azbank.entiry.Account;
import com.azbank.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepo repo;
	
	//after account
	private final TransactionClient client;
	
	public List<Account> findAll(){
		return repo.findAll();
	}
	
	public void save(Account a) {
		repo.save(a);
	}
	
	public void update(Account a) {
		repo.saveAndFlush(a);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public List<Account> findAllAccountsByCustomer(Integer id){
		return repo.findByCustomerId(id);
	}
	
	//call transaction by using FullAccountResponse
	
	public FullAccountResponse findAccountWithTransactions(Integer id) {
		var account= repo.findById(id)
				.orElse(Account.builder()
						.accountNo("NOT FOUND")
						.type("NOT FOUND")
						.balance(null)
						.build());
		
				var transactions= client.findAllbyAccount(id);
				
				return FullAccountResponse.builder()
						.accountNo(account.getAccountNo())
						.type(account.getType())
						.balance(account.getBalance())
						.transactions(transactions)
						.build();
	}
}
