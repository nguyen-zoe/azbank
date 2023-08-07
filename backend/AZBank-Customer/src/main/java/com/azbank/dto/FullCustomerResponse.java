package com.azbank.dto;


import java.util.List;

import com.azbank.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullCustomerResponse {
	
	private String fullName;
	private String email;
	private String address;
//	private String password;
	
	List<Account> accounts;
}
