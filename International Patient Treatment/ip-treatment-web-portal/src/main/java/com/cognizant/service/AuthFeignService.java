package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.model.Admin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthFeignService {

	@Autowired
	private AuthenticationFeign authClient;

	public ResponseEntity<?> getToken(Admin usercredentials) {
		log.debug("userCredentials{}:", usercredentials);
		return authClient.login(usercredentials);
	}

}