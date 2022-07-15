package com.cognizant.treatments.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.treatments.model.AuthResponse;



@FeignClient(url="localhost:8083/auth",name="AUTH")
public interface AuthClient {
	@GetMapping(path="/validate")
	public AuthResponse verifyToken(@RequestHeader(name="Authorization",required=true)String token);
	

}
