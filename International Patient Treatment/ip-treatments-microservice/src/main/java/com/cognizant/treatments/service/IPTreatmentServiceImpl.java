package com.cognizant.treatments.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.treatments.client.AuthClient;
import com.cognizant.treatments.exception.InvalidTokenException;
import com.cognizant.treatments.model.AuthResponse;
import com.cognizant.treatments.model.PatientDetail;
import com.cognizant.treatments.model.TreatmentPlan;
import com.cognizant.treatments.repository.PatientDetailRepository;
import com.cognizant.treatments.repository.TreatmentPlanRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class IPTreatmentServiceImpl implements IPTreatmentService {

	
	/**
	 * autowires the AuthClient(feign client) to communicate with authorization
	 * autowires PatientDetailDetailRepository and
	 * TreatmentPlanRepository
	 */
	
	@Autowired
	AuthClient authClient;
	
	@Autowired
	PatientDetailRepository patientDetailRepository;

	@Autowired
	TreatmentPlanRepository treatmentPlanRepository;

	
	/**
	 * to return the treatment plan
	 * @param patientDetail,cost
	 * @return TreatmentPlan
	 */
	

	@Override
	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail, int cost) {
		log.info("START :: Method :: getTreatmentPlan() :: ");
		Calendar currentDate = Calendar.getInstance();
		String commencementDate = reviewDateAndMonth(currentDate.get(Calendar.DATE)) + "/"
				+ reviewDateAndMonth(currentDate.get(Calendar.MONTH) + 1) + "/" + currentDate.get(Calendar.YEAR);
		patientDetail.setTreatmentCommencementDate(commencementDate);
		patientDetailRepository.save(patientDetail);
		String specialist = "None";

		if (patientDetail.getTreatmentPackageName().equalsIgnoreCase("package1")) {
			specialist = "Senior Specialist";
			currentDate.add(Calendar.WEEK_OF_YEAR, 6);
		} else if (patientDetail.getTreatmentPackageName().equalsIgnoreCase("package2")) {
			specialist = "Junior Specialist";
			currentDate.add(Calendar.WEEK_OF_YEAR, 4);
		}

		String endDate = reviewDateAndMonth(currentDate.get(Calendar.DATE)) + "/"
				+ reviewDateAndMonth(currentDate.get(Calendar.MONTH) + 1) + "/" + currentDate.get(Calendar.YEAR);

		TreatmentPlan plan = new TreatmentPlan(0, patientDetail, "Test1 , Test2",
				patientDetail.getTreatmentPackageName(), specialist, cost, "In progress", commencementDate, endDate);

		treatmentPlanRepository.save(plan);
		log.info("END :: Method :: getTreatmentPlan() :: ");
		return plan;
	}

	/**
	 *  returns the reviewDatAndMonth
	 * @param dateOrMonth
	 * @return String
	 */
	
	public String reviewDateAndMonth(int dateOrMonth) {
		log.info("START :: Method :: reviewDateAndMonth() :: ");
		log.info("END :: Method :: reviewDateAndMonth() :: ");
		if (dateOrMonth < 10)
			return "0" + Integer.toString(dateOrMonth);
		else
			return Integer.toString(dateOrMonth);
	}


	/**
	 * to return all the treatment plan
	 * 
	 * @return List<TreatmentPlan>
	 */
	
	
	@Override
	public List<TreatmentPlan> getAllPlans() {
		log.info("START :: Method :: getAllPlans() :: ");
		log.info("END :: Method :: getAllPlans() :: ");
		return treatmentPlanRepository.getAllplans();
	}
	/**
	 * to return all the Ongoing treatment plan
	 * 
	 * @return List<TreatmentPlan>
	 */
	
	
	@Override
	public List<TreatmentPlan> getAllOnGoingplans() {
		log.info("START :: Method :: getAllOnGoingplans() :: ");
		log.info("END :: Method :: getAllOnGoingplans() :: ");
		return treatmentPlanRepository.getAllOnGoingplans();
	}

	
	/**
	 * to return the specific patient details
	 * @param id
	 * @return PatientDetail
	 */
	
	
	@Override
	public PatientDetail getPatient(long ptId) {
		log.info("START :: Method :: getPatient() :: ");
		log.info("END :: Method :: getPatient() :: ");
		return patientDetailRepository.getPatientById(ptId);
	}

	

	/**
	 * to return the specific treatment plan
	 * @param id
	 * @return TreatmentPlan
	 */
	
	@Override
	public TreatmentPlan getPlan(long ptId) {
		log.info("START :: Method :: getPlan() :: ");
		log.info("END :: Method :: getPlan() :: ");
		return treatmentPlanRepository.getPlanUser(ptId);
	}

	
	/**
	 * to update the treatment plan
	 * @param id
	 */
	
	@Override
	public void updatePlan(long pId) {
		log.info("START :: Method :: updatePlan() :: ");
		TreatmentPlan tp = treatmentPlanRepository.getPlanUser(pId);
		tp.setStatus("Completed");
		treatmentPlanRepository.save(tp);
		log.info("END :: Method :: updatePlan() :: ");
	}

	

	/**
	 * to return all the registered patient
	 * 
	 * @return List<PatientDetail>
	 */
	
	@Override
	public List<PatientDetail> getAllPatients() {
		log.info("START :: Method :: getAllPatients() :: ");
		log.info("END :: Method :: getAllPatients() :: ");
		return patientDetailRepository.findAll();
	}
	
	public AuthResponse validateToken(String token) {

		AuthResponse authResponse = null;
		try {
			authResponse = authClient.verifyToken(token);
			if (!authResponse.isValid()) {
				throw new InvalidTokenException();
			}
		} catch (Exception e) {
			throw new InvalidTokenException();
		}

		return authResponse;
	}

}
