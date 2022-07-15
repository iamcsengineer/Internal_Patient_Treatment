package com.cognizant.clients;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;


@FeignClient(url = "http://localhost:9092/iptms", name = "insurance-claim-microservice")
public interface ICClient {
	
	@RequestMapping(value = "/getallinsurerdetail", method = RequestMethod.GET)
	public List<InsurerDetail> getAllInsurerDetail(@RequestHeader("Authorization") String token);
	
	@RequestMapping(value = "/getinsurerbypackagename/{packageName}", method = RequestMethod.GET)
	public InsurerDetail getInsurerDetail(@PathVariable String packageName,@RequestHeader("Authorization") String token);
	
	@RequestMapping(value = "/getinsuredpatient/{patientId}", method = RequestMethod.GET)
	public InitiateClaim getInsurerdPatient(@RequestHeader("Authorization") String token,@PathVariable long patientId);
	

	@RequestMapping(value = "/initiateclaim", method = RequestMethod.POST)
	public int initiateClaim(@RequestHeader("Authorization") String token,@RequestBody InitiateClaim initiateClaim);
}
