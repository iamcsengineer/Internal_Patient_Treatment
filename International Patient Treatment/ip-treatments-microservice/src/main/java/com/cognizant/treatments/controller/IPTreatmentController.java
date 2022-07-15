package com.cognizant.treatments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.treatments.exception.InvalidTokenException;
import com.cognizant.treatments.model.AuthResponse;
import com.cognizant.treatments.client.AuthClient;
import com.cognizant.treatments.model.PatientDetail;
import com.cognizant.treatments.model.TreatmentPlan;
import com.cognizant.treatments.service.IPTreatmentServiceImpl;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
@RequestMapping("/iptms")
public class IPTreatmentController {
	
	
	private static final String AUTHSUCCESS = "Authorization Successful";
	private static final String AUTHUNSUCCESS = "Authorization Unsuccessful";
	
	
	
	@Autowired
	AuthClient authclient;

	@Autowired
	IPTreatmentServiceImpl iptService;

	/**
	 {
	 "id":1,
	 "name":"John",
	 "age":21,
	 "ailment":"Arthritis",
	 "treatmentPackageName":"Package 1"
	 }
	 */
	
	/**
	 * Method-POST, http://localhost:9091/iptreatments/formulatetreatmenttimetable/7000
	 * 
	 * to get the list of all the patients 
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token,patientDetails,cost
	 * @return patientDetail and cost
	 * @throws InvalidTokenException
	 */
	
	
	@PostMapping(value = "/formulatetreatmenttimetable/{cost}")
	public TreatmentPlan formulateTreatmentTimetable(@RequestHeader(name = "Authorization") String token, @RequestBody PatientDetail patientDetail, @PathVariable int cost)throws InvalidTokenException {
		log.info("START :: Method :: formulateTreatmentTimetable() :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("Time Table formulated!");
			return iptService.getTreatmentPlan(patientDetail, cost);
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}		
	}
	
	/**
	 * Method-GET, http://localhost:9091/iptreatments/getallpatients
	 * 
	 * to get the list of all the patients 
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token
	 * @return list of PatientDetail type
	 * @throws InvalidTokenException
	 */
	
	@GetMapping("/getallpatients")
	public List<PatientDetail> getAllPatients(@RequestHeader(name = "Authorization") String token)throws InvalidTokenException {
		log.info("START :: Method :: getAllPatients() :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("All patients are being displayed successfully!");
			return iptService.getAllPatients();
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}		
	}
	
	
	/**
	 * Method-GET, http://localhost:9091/iptreatments/getallplans
	 * 
	 * to get the list of all the treatment plan available for patients
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token
	 * @return list of TreatmentPlan type
	 * @throws InvalidTokenException
	 */

	@GetMapping("/getallplans")
	public List<TreatmentPlan> getAllPlans(@RequestHeader(name = "Authorization") String token)throws InvalidTokenException {
		log.info("START :: Method :: getAllPlans() :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("All plans are being displayed successfully!");
			return iptService.getAllPlans();
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}	
	}

	/**
	 * Method-GET, http://localhost:9091/iptreatments/getallongoingtreatments
	 * 
	 * to get the list of all the On going
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token
	 * @return list of PatientDetail type
	 * @throws InvalidTokenException
	 */
	
	@GetMapping("/getallongoingtreatments")
	public List<TreatmentPlan> getAllOnGoingTreatments(@RequestHeader(name = "Authorization") String token)throws InvalidTokenException {
		log.info("START :: Method :: getAllOnGoingTreatments :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("All Ongoing Treatment are being displayed successfully!");
			return iptService.getAllOnGoingplans();
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}		
	}
	
	
	/**
	 * Method-GET, http://localhost:9091/iptreatments/getpatient/1
	 * 
	 * to get the specific patient details 
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token, patientId
	 * @return PatientDetail
	 * @throws InvalidTokenException
	 */

	@GetMapping("/getpatient/{patientId}")
	public PatientDetail getPatient(@RequestHeader(name = "Authorization") String token, @PathVariable long patientId)throws InvalidTokenException {
		log.info("START :: Method :: getPatient() :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("Patient by id: "+patientId+" is being displayed successfully!");
			System.out.println("======"+iptService.getPatient(patientId));
			return iptService.getPatient(patientId);
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}	
	}

	/**
	 * Method-GET, http://localhost:9091/iptreatments/getplan/1
	 * 
	 * to get the treatment plan of specific patient
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token, patientId
	 * @return TreatmentPlan
	 * @throws InvalidTokenException
	 */
	@GetMapping("/getplan/{patientId}")
	public TreatmentPlan getAPlan(@RequestHeader(name = "Authorization") String token, @PathVariable int patientId)throws InvalidTokenException {
		log.info("START :: Method :: getAPlan() :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("Plan is displayed!");
			return iptService.getPlan(patientId);
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}	
	}
	/**
	 * Method-PUT, http://localhost:9091/iptreatments/updateplan/1
	 * 
	 * to update the details of specific patient
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token,patientId
	 * @throws InvalidTokenException
	 */
	@PutMapping("/updateplan/{patientId}")
	public void updatePlan(@RequestHeader(name = "Authorization") String token, @PathVariable long patientId)throws InvalidTokenException {
		log.info("START :: Method :: updatePlan() :: ");
		AuthResponse authResponse = authclient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			log.info("Plan is updated!");
			iptService.updatePlan(patientId);
		}else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}	
	}

}