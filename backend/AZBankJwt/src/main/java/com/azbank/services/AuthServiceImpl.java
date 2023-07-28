package com.azbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.azbank.dtos.SignupRequest;
import com.azbank.dtos.UserDTO;
import com.azbank.models.User;
import com.azbank.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(SignupRequest signupRequest) {
		
	
		        User user = new User();
		    user.setEmail(signupRequest.getEmail());
		    user.setName(signupRequest.getName());
		    user.setPhone(signupRequest.getPhone());
		    user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		        
		    //save created User
		        User createdUser = userRepository.save(user);
		        
		        
		        // this can use ModelMapper...
		        //convert to DTO
		        UserDTO userDTO = new UserDTO();
		        userDTO.setId(createdUser.getId());
		        userDTO.setEmail(createdUser.getEmail());
		        userDTO.setName(createdUser.getName());
		        userDTO.setPhone(createdUser.getPhone());
		        
		        return userDTO;
		      
		    
	}
}
