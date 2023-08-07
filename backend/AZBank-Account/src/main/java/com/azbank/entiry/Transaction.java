package com.azbank.entiry;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
public class Transaction {
	private BigDecimal amount;
	private String type; //withdraw or deposit (cash transaction)
	@CreationTimestamp
	private LocalDate createdData;
	private String reference; // should be randomly generate
}
