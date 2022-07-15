package com.cognizant.treatments.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.treatments.model.PatientDetail;
import com.cognizant.treatments.model.TreatmentPlan;



@Service
public interface IPTreatmentService {
	
	/**
	 * to return the treatment plan
	 * @param patientDetail,cost
	 * @return List<IPTreatmentPackage>
	 */
	
	TreatmentPlan getTreatmentPlan(PatientDetail patientDetail , int cost);
	
	
	
	/**
	 * to return all the treatment plan
	 * 
	 * @return List<TreatmentPlan>
	 */
	
	
	List<TreatmentPlan> getAllPlans();
	
	/**
	 * to return all the Ongoing treatment plan
	 * 
	 * @return List<TreatmentPlan>
	 */
	List<TreatmentPlan> getAllOnGoingplans();
	
	/**
	 * to return all the registered patient
	 * 
	 * @return List<PatientDetail>
	 */
	
	
	List<PatientDetail> getAllPatients();
	
	
	/**
	 * to return the specific patient details
	 * @param id
	 * @return PatientDetail
	 */
	
	
	PatientDetail getPatient(long patientId);
	
	
	/**
	 * to return the specific treatment plan
	 * @param id
	 * @return TreatmentPlan
	 */
	
	TreatmentPlan getPlan(long patientId);
	
	
	/**
	 * to update the treatment plan
	 * @param id
	 */
	
	
	void updatePlan(long patientId);
	}
