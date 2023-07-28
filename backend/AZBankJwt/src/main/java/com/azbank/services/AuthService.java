package com.azbank.services;

import com.azbank.dtos.SignupRequest;
import com.azbank.dtos.UserDTO;

public interface AuthService {

	 UserDTO createUser(SignupRequest signupRequest);
}
