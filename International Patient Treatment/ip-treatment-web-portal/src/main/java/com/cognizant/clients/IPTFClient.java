package com.cognizant.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.PatientDetail;
import com.cognizant.model.TreatmentPlan;

@FeignClient(url = "http://localhost:9091/iptms", name = "iptms-treatments-microservice")
public interface IPTFClient {
	
	@RequestMapping(value = "/formulatetreatmenttimetable/{cost}", method = RequestMethod.POST)
	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader("Authorization") String token,@RequestBody PatientDetail patientDetail,@PathVariable int cost);
	
	
	@GetMapping("/getpatient/{ptId}")
	public PatientDetail getPatient(@PathVariable long ptId,@RequestHeader("Authorization") String token );
	
	@GetMapping("/getallplans")
	public List<TreatmentPlan> getAllPatients(@RequestHeader("Authorization") String token);
	
	
	@GetMapping("/getallongoingtreatments")
	public List<TreatmentPlan> getAllOnGoingTreatments(@RequestHeader("Authorization") String token);
	
	@GetMapping("/getplan/{ptId}")
	public TreatmentPlan getAPlan(@PathVariable long ptId,@RequestHeader("Authorization") String token );
	
	@PutMapping("/updateplan/{pId}")
	public void updatePlan(@PathVariable long pId,@RequestHeader("Authorization") String token);
}
