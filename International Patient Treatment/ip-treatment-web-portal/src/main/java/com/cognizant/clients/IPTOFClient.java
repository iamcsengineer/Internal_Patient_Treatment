package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.SpecialistDetail;

@FeignClient(url = "http://localhost:9090/iptms", name = "ipt-offering-microservice")
public interface IPTOFClient {
	
	@RequestMapping(path = "/iptreatmentpackages", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackages(@RequestHeader(name = "Authorization") String token);
	
	@RequestMapping(path = "/iptreatmentpackagebyname/{category}/{packageName}", method = RequestMethod.GET)
	public ResponseEntity<?> getIPTreatmentPackageByAilmentCategoryAndName(@PathVariable String category,@PathVariable String packageName, @RequestHeader(name = "Authorization") String token);
	
	@RequestMapping(path = "/specialists", method = RequestMethod.GET)
	public  ResponseEntity<List<SpecialistDetail>> getSpecialists(@RequestHeader(name = "Authorization") String token);
}
