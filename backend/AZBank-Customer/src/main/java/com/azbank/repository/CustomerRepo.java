package com.azbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azbank.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
