package com.cognizant.offerings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.offerings.client.AuthClient;
import com.cognizant.offerings.model.AuthResponse;
import com.cognizant.offerings.model.IPTreatmentPackage;
import com.cognizant.offerings.model.SpecialistDetail;
import com.cognizant.offerings.service.IPTreatmentOfferingsService;
import com.cognizant.offerings.exception.InvalidTokenException;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/iptms")
public class IPTreatmentOfferingsController {

	/**
	 * instance variables for authorization success and unsuccess
	 */
	private static final String AUTHSUCCESS = "Authorization Successful";
	private static final String AUTHUNSUCCESS = "Authorization Unsuccessful";

	/**
	 * autowires the AuthClient(feign client) to communicate with authorization
	 * microservice autowires the IPTreatmentOfferingsService
	 */
	@Autowired
	AuthClient authClient;

	@Autowired
	IPTreatmentOfferingsService ipTreatmentOfferingsService;

	/**
	 * Method-GET, http://localhost:9090/iptms/iptreatmentpackages
	 * 
	 * to get the list of all the treatment packages available for patients
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token
	 * @return ResponseEntity<List<IPTreatmentPackage>> with status code
	 * @throws InvalidTokenException
	 */
	@GetMapping(path = "/iptreatmentpackages")
	public ResponseEntity<List<IPTreatmentPackage>> getIPTreatmentPackages(
			@RequestHeader(name = "Authorization") String token) throws InvalidTokenException {
		log.info("START :: Method :: getIPTreatmentPackages() :: ");
		AuthResponse authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			return new ResponseEntity<>(ipTreatmentOfferingsService.getIPTreatmentPackages(), HttpStatus.OK);

		} else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}
	}

	/**
	 * Method-GET,
	 * http://localhost:9090/iptm/iptreatmentpackagebyname/Urology/Package1
	 * 
	 * to return the treatment package based on specified ailment category and
	 * package name
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token
	 * @param category
	 * @param packageName
	 * @return ResponseEntity<IPTreatmentPackage> with status code
	 * @throws InvalidTokenException
	 */
	@GetMapping(path = "/iptreatmentpackagebyname/{category}/{packageName}")
	public ResponseEntity<IPTreatmentPackage> getIPTreatmentPackageByAilmentCategoryAndName(
			@RequestHeader(name = "Authorization") String token, @PathVariable String category,
			@PathVariable String packageName) throws InvalidTokenException {
		log.info("START :: Method :: getIPTreatmentPackageByAilmentCategoryAndName() :: ");
		AuthResponse authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			return new ResponseEntity<>(
					ipTreatmentOfferingsService.getIPTreatmentPackageByAilmentCategoryAndName(packageName, category),
					HttpStatus.OK);
		} else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}
	}

	/**
	 * Method-GET, http://localhost:9090/iptms/specialists
	 * 
	 * to return the list of all the specialist details
	 * only after verifying that the user trying to use this service 
	 * is authenticated or not
	 * 
	 * @param token
	 * @return ResponseEntity<List<SpecialistDetail>> with status code
	 * @throws InvalidTokenException
	 */
	@GetMapping(value = "/specialists")
	public ResponseEntity<List<SpecialistDetail>> getSpecialists(@RequestHeader(name = "Authorization") String token)
			throws InvalidTokenException {
		log.info("START :: Method :: getSpecialists() :: ");
		AuthResponse authResponse = authClient.verifyToken(token);
		if (authResponse.isValid()) {
			log.info(AUTHSUCCESS);
			return new ResponseEntity<>(ipTreatmentOfferingsService.getSpecialists(), HttpStatus.OK);
		} else {
			log.info(AUTHUNSUCCESS);
			throw new InvalidTokenException();
		}
	}
}
