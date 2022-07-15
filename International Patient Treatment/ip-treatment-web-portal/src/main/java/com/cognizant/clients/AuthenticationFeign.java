package com.cognizant.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.Admin;
import com.cognizant.model.AuthResponse;


@FeignClient(name = "AUTH",url = "http://localhost:8083/auth")
public interface AuthenticationFeign {
	/**
	 * to allow a user with valid Credentials to login into the app and access the functionalities.
	 * 
	 * @param Admin Object
	 * @return ResponseEntity<?> of login
	 */
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestBody Admin userlogincredentials);
	/**
	 * to verify the token that the user request is valid
	 * 
	 * @param token
	 * @return AuthResponse
	 */
	@GetMapping(value="/validate")
	public AuthResponse verifyToken(@RequestHeader("Authorization") String token);
}
