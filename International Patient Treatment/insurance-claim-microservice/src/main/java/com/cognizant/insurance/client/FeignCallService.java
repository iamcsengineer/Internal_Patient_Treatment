package com.cognizant.insurance.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.insurance.model.TreatmentPlan;






@FeignClient(name="iptms-treaments-microservice",url="http://localhost:9091/iptms")
public interface FeignCallService {

	
	/**
	 * Gets the treatment plan of a patient based on patient id. 
	 *
	 * @param patientId
	 * @return
	 */
	@GetMapping("/getplan/{patientId}")
	public TreatmentPlan getPlan(@PathVariable long patientId);
	
	/**
	 * Gets all the treatment plans available for patients
	 * 
	 * @param token
	 * @return
	 */
	@GetMapping("/getallplans")
	public List<TreatmentPlan> getAllPlans(@RequestHeader(name = "Authorization") String token);
}
