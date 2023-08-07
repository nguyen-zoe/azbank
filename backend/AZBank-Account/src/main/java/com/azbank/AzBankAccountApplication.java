package com.azbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AzBankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzBankAccountApplication.class, args);
	}

}
