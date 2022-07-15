package com.cognizant.insurance.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.insurance.model.InitiateClaim;
import com.cognizant.insurance.model.InsurerDetail;


public interface InsuranceClaimService {
	
	/**
	 * to return the list of all insurers
	 * 
	 * @return List<InsurerDetail>
	 */
	public List<InsurerDetail> getAllInsurerDetail();
	
	
	/**
	 * to return the details of a insurer 
	 * based on the insurer's package name
	 * 
	 * @param insurerPackageName
	 * @return InsurerDetail
	 */
	public InsurerDetail getInsurerDetail(String insurerPackageName);
	
	
	/**
	 * to return the outstanding amount that
	 * the patient needs to pay
	 * after claiming his insurance
	 * 
	 * @param token
	 * @param initiateClaim
	 * @return outstanding amount
	 */
	public double initiateClaim(@RequestHeader(name = "Authorization") String token,InitiateClaim initiateClaim);
}
