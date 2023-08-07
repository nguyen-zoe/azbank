package com.azbank.dto;

import java.math.BigDecimal;
import java.util.List;

import com.azbank.entiry.Transaction;

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
public class FullAccountResponse {

	private String accountNo;
	private String type;
	private BigDecimal balance;
	private Integer customerId;
	
	List<Transaction> transactions;
}
