package com.azbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azbank.dtos.AuthenticationRequest;
import com.azbank.dtos.AuthenticationResponse;
import com.azbank.services.jwt.UserDetailsServiceImpl;
import com.azbank.utils.JwtUtil;

import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
//	 @PostMapping("/authenticate")
//	    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) 
//	    		throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
//	        try {
//	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
//	        } catch (BadCredentialsException e) {
//	            throw new BadCredentialsException("Incorrect username or password!");
//	        } catch (DisabledException disabledException) {
//	            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
//	            return null;
//	        }
//
//	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());
//
//	        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
//
//	        return new AuthenticationResponse(jwt);
//
//	    }

	
	
	@PostMapping("/authentication")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response ) 
			throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect Username or password");
		} catch (DisabledException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not created... Register User first");
			return null;
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		
		
		final String jwt= jwtUtil.generateToken(userDetails.getUsername());
	
		return new AuthenticationResponse(jwt);
}
}
