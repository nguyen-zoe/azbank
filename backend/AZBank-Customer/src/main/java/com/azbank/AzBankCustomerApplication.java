package com.azbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AzBankCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzBankCustomerApplication.class, args);
	}

}
