package com.azbank.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
	


	private String jwt;

	
	public AuthenticationResponse(String jwt) {
		this.setJwt(jwt);
	}


	public String getJwt() {
		return jwt;
	}


	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}
