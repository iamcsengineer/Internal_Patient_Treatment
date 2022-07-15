package com.cognizant.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cognizant.clients.ICClient;
import com.cognizant.clients.IPTFClient;
import com.cognizant.clients.IPTOFClient;
import com.cognizant.model.IPTreatmentPackage;
import com.cognizant.model.InitiateClaim;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.PatientDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PortalService {

	@SuppressWarnings("unused")
	private static final InitiateClaim InitiateClaim = null;
	/**
	 * autowires the IPTFClient(IP-treatments-Microservice feign client) to communicate with authorization
	 *
	 */
	@Autowired
	IPTFClient iPTFClient;
	/**
	 * autowires the IPTFOClient(IP-treatment-Offernings feign client) to communicate with authorization
	 *
	 */
	
	@Autowired
	IPTOFClient iPTFOClient;
	/**
	 * autowires the ICClient(Insurance-Claim-Microservice feign client) to communicate with authorization
	 *
	 */
	@Autowired
	ICClient iCClient;
	/**
	 * 
	 * this method will return the List of Specialist Available in the Hospital.
	 * 
	 * @param token
	 * @return List<SpecialistDetail>
	 * 
	 */
	public List<SpecialistDetail> getSpecialistDetail(String token) {
		log.info("START :: Method :: getSpecialistDetail() :: ");
		List<SpecialistDetail> specialistDetail = iPTFOClient.getSpecialists(token).getBody();
		log.info("END :: Method :: getSpecialistDetail() :: ");
		return specialistDetail;
	}
	/**
	 * 
	 * this method will return the List of Available Insurers in the Hospital.
	 * 
	 * @param token
	 * @return List<InsurerDetail>
	 * 
	 */
	public List<InsurerDetail> getInsurerDetail(String token) {
		log.info("START :: Method :: getInsurerDetail() :: ");
		List<InsurerDetail> insurerDetail = iCClient.getAllInsurerDetail(token);
		log.info("END :: Method :: getInsurerDetail() :: ");
		return insurerDetail;
	}
	/**
	 * 
	 * this method will return the Treatment Plan of a Patient
	 * 
	 * @param token
	 * @param PatientDetail Object
	 * @param Cost
	 * @return TreatmentPlan Object
	 * 
	 */
	public TreatmentPlan registerPatient(String token,PatientDetail patient,int cost) {
		log.info("START :: Method :: registerPatient() :: ");
		TreatmentPlan treatmentPlan = iPTFClient.formulateTreatmentTimetable(token,patient, cost);
		log.info("END :: Method :: registerPatient() :: ");
		return treatmentPlan;
	}


	/**
	 * 
	 * this method will return the List of Treatment Packages Available in the Hospital.
	 * 
	 * @param token
	 * @return List<IPTreatmentPackage>
	 * 
	 */
	public List<IPTreatmentPackage> getPackageDetail(String token) {
		log.info("START :: Method :: getPackageDetail() :: ");
		@SuppressWarnings("unchecked")
		List<IPTreatmentPackage> packageDetail = (List<IPTreatmentPackage>)iPTFOClient.getIPTreatmentPackages(token).getBody();
		log.info("END :: Method :: getPackageDetail() :: ");
		return packageDetail;
	}

	/**
	 * 
	 * this method will return the List of ALL Treatments in the Hospital.
	 * 
	 * @param token
	 * @return List<TreatmentPlan>
	 * 
	 */

	public List<TreatmentPlan> getTreatmentPlanList(String token) {
		log.info("START :: Method :: getTreatmentPlanList() :: ");
		List<TreatmentPlan> treatmentPlan = iPTFClient.getAllPatients(token);
		log.info("END :: Method :: getTreatmentPlanList() :: ");
		return treatmentPlan;
	}
	/**
	 * 
	 * this method will return the List of On Going Treatments in the Hospital.
	 * 
	 * @param token
	 * @return List<TreatmentPlan>
	 * 
	 */

	public List<TreatmentPlan> getOnGoingTreatmentPlanList(String token) {
		log.info("START :: Method :: getTreatmentPlanList() :: ");
		List<TreatmentPlan> treatmentPlan = iPTFClient.getAllOnGoingTreatments(token);
		log.info("END :: Method :: getTreatmentPlanList() :: ");
		return treatmentPlan;
	}
	/**
	 * 
	 * this method will return the List of Available Insurers in the Hospital.
	 * 
	 * @param token
	 * @return List<InsurerDetail>
	 * 
	 */
	public List<InsurerDetail> claimInsurance(String token) {
		log.info("START :: Method :: claimInsurance() :: ");
		List<InsurerDetail> insurerDetail = iCClient.getAllInsurerDetail(token);
		log.info("END :: Method :: claimInsurance() :: ");
		return insurerDetail;
	}
	/**
	 * 
	 * this method will return the Particular Insurance Provider selected for a patient.
	 * 
	 * @param token
	 * @param packageName
	 * @return InsurerDetail Object
	 * 
	 */
	public InsurerDetail getInsurerDetail(String packageName, String token) {
		log.info("START :: Method :: getInsurerDetail() :: ");
		InsurerDetail insurerDetail =iCClient.getInsurerDetail(packageName, token);
		log.info("END :: Method :: getInsurerDetail() :: ");
		return insurerDetail;
	}
	/**
	 * 
	 * this method will return the Particular Patient based on patient ID.
	 * 
	 * @param token
	 * @param ptId
	 * @return List<InsurerDetail>
	 * 
	 */
	public PatientDetail getPatientDetail(long ptId, String token) {
		log.info("START :: Method :: getPatientDetail() :: ");
		PatientDetail patientDetail =iPTFClient.getPatient(ptId,token);
		log.info("END :: Method :: getPatientDetail() :: ");
		return patientDetail;
	}
	/**
	 * 
	 * this method will return the Treatment Plan of a Particular Patient.
	 * 
	 * @param token
	 * @param ptId
	 * @return List<InsurerDetail>
	 * 
	 */
	public TreatmentPlan getTreatmentDetail(long ptId, String token) {
		log.info("START :: Method :: getTreatmentDetail() :: ");
		TreatmentPlan treatmentPlan =iPTFClient.getAPlan(ptId,token);
		log.info("END :: Method :: getTreatmentDetail() :: ");
		return treatmentPlan;
	}
	/**
	 * 
	 * this method will return the Remaining Amount to be paid after claim Settlement.
	 * 
	 * @param token
	 * @param InitiateClaim Object
	 * @return List<InsurerDetail>
	 * 
	 */
	public int initiateClaim(String token,InitiateClaim initiateClaim) {
		log.info("START :: Method :: initiateClaim() :: ");
		int amt = iCClient.initiateClaim(token,initiateClaim);
		log.info("END :: Method :: initiateClaim() :: ");
		return amt;
	}
	/**
	 * 
	 * this method will Update Patient Status from On Progress to Complete.
	 * 
	 * @param token
	 * @param ptId
	 * @return List<InsurerDetail>
	 * 
	 */
	public void updatePlan(long ptId, String token) {
		log.info("START :: Method :: updatePlan() :: ");
		log.info("END :: Method :: updatePlan() :: ");
		iPTFClient.updatePlan(ptId,token);
	}
	


	public String getTokenWithHeader(String token) {
		log.info("START :: Method :: getTokenWithHeader() :: ");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);
		log.info("END :: Method :: getTokenWithHeader() :: ");
		return headers.getFirst("Authorization");
	}

}
