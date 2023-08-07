package com.azbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.azbank.dto.FullCustomerResponse;
import com.azbank.entity.Customer;
import com.azbank.repository.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepo customerRepo;

	private final AccountClient client;

	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	public void saveCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	public void update(Customer customer) {
		customerRepo.saveAndFlush(customer);

	}

	public void delete(Integer id) {
		customerRepo.deleteById(id);
	}

	public FullCustomerResponse findCustomerWithAccounts(Integer customerId) {
		var customer = customerRepo.findById(customerId)
				.orElse(Customer.builder().fullName("NOT FOUND").address("NOT FOUND").email("NOT FOUND").build());

		var accounts = client.findAllAccountsByCustomer(customerId);

		return FullCustomerResponse.builder().fullName(customer.getFullName()).email(customer.getEmail())
				.address(customer.getAddress()).accounts(accounts)
	.build();
	}
	

	
}
