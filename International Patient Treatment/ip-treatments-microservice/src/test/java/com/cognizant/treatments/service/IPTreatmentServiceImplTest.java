package com.cognizant.treatments.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.treatments.client.AuthClient;
import com.cognizant.treatments.exception.InvalidTokenException;
import com.cognizant.treatments.model.AuthResponse;
import com.cognizant.treatments.model.PatientDetail;
import com.cognizant.treatments.model.TreatmentPlan;
import com.cognizant.treatments.repository.PatientDetailRepository;
import com.cognizant.treatments.repository.TreatmentPlanRepository;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 *
 *		@ExtendWith is a repeatable annotation that is used to register 
 *		extensions for the annotated test class or test method
 */
@ExtendWith(MockitoExtension.class)
class IPTreatmentServiceImplTest {

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object automatically
	 */
	@Mock
	PatientDetailRepository patientDetailRepository;

	@Mock
	AuthClient authClient;

	@Mock
	TreatmentPlanRepository treatmentPlanRepository;
	
	@InjectMocks
	IPTreatmentServiceImpl iPTreatmentServiceImpl;
	
	/**
	 * to test validation of token
	 */
	@Test
	public void test_ValidateToken() {
		when( authClient.verifyToken("token")).thenReturn(new AuthResponse("id", "name", true));
		assertEquals( "name",iPTreatmentServiceImpl.validateToken("token").getName());
	}

	/**
	 * to test validate token with invalid token
	 */
	@Test
	public void test_ValidateTokenWithInvalidToken() {
		when( authClient.verifyToken("token")).thenReturn(new AuthResponse("id", "name", false));
		assertThrows( InvalidTokenException.class, ()->iPTreatmentServiceImpl.validateToken("token"));
	}
	
	/**
	 * to test validate token throwing exception
	 */
	@Test
	public void test_ValidateTokenThrowsException() {
		when( authClient.verifyToken("token")).thenThrow(RuntimeException.class);
		assertThrows( InvalidTokenException.class, ()->iPTreatmentServiceImpl.validateToken("token"));
	}
	
	/**
	 * to test getting of treatment package of Senior specialist- Package 1
	 */
	@Test
	public void test_GetTreatmentPlanPackage1() {
		PatientDetail patientDetail= new PatientDetail(1, "John", 26, "Arthritis", "Package1", "10/03/2021");
		TreatmentPlan treatmentPlan= iPTreatmentServiceImpl.getTreatmentPlan(patientDetail, 12000);
		assertEquals("Senior Specialist", treatmentPlan.getSpecialist());
		verify(treatmentPlanRepository,times(1)).save(treatmentPlan);
		verify(patientDetailRepository,times(1)).save(patientDetail);
	}
	
	/**
	 * to test getting of treatment package of Junior specialist- Package 2
	 */
	@Test
	public void test_GetTreatmentPlanPackage2() {
		PatientDetail patientDetail= new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan= iPTreatmentServiceImpl.getTreatmentPlan(patientDetail, 12000);
		assertEquals("Junior Specialist", treatmentPlan.getSpecialist());
		verify(treatmentPlanRepository,times(1)).save(treatmentPlan);
		verify(patientDetailRepository,times(1)).save(patientDetail);
	}
	
	/**
	 * to test the functioning of reviewing date and month
	 */
	@Test
	public void test_ReviewDateAndMonth() {
		assertEquals("10", iPTreatmentServiceImpl.reviewDateAndMonth(10));
		assertEquals("01", iPTreatmentServiceImpl.reviewDateAndMonth(1));
		assertEquals("05", iPTreatmentServiceImpl.reviewDateAndMonth(5));
	}

	/**
	 * to test that all treatment plans are fetched properly
	 */
	@Test
	public void test_GetAllPlans() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		PatientDetail patientDetail= new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan= new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist", 
				12000, "In Progress", "10/03/2021", "10/04/2021");
		treatmentPlans.add(treatmentPlan);
		when(treatmentPlanRepository.getAllplans()).thenReturn(treatmentPlans);
		assertEquals(treatmentPlans, iPTreatmentServiceImpl.getAllPlans());
	}
	
	/**
	 * to test that all ongoing treatment plans are fetched properly
	 */
	@Test
	public void test_getAllOnGoingplans() {
		List<TreatmentPlan> treatmentPlans = new ArrayList<TreatmentPlan>();
		PatientDetail patientDetail= new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan= new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist", 
				12000, "In Progress", "10/03/2021", "10/04/2021");
		treatmentPlans.add(treatmentPlan);
		when(treatmentPlanRepository.getAllOnGoingplans()).thenReturn(treatmentPlans);
		assertEquals(treatmentPlans, iPTreatmentServiceImpl.getAllOnGoingplans());
	}

	/**
	 * to test that a patient's detail is fetched properly
	 * on the basis of patient id
	 */
	@Test
	public void test_GetPatientById() {
		PatientDetail patientDetail = new PatientDetail();
		patientDetail.setId(2);
		when(patientDetailRepository.getPatientById(2)).thenReturn(patientDetail);
		assertEquals(patientDetail.getId(), iPTreatmentServiceImpl.getPatient(2).getId());
	}

	/**
	 * to test that a treatment plan's detail is fetched properly
	 * on the basis of patient id
	 */
	@Test
	public void test_GetPlan() {
		PatientDetail patientDetail= new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan= new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist", 
				12000, "In Progress", "10/03/2021", "10/04/2021");
		when(treatmentPlanRepository.getPlanUser(1)).thenReturn(treatmentPlan);
		assertEquals(treatmentPlan, iPTreatmentServiceImpl.getPlan(1));
	}

	/**
	 * to test the functioning of updating of status
	 */
	@Test
	public void test_UpdatePlan() {
		PatientDetail patientDetail= new PatientDetail(1, "John", 26, "Arthritis", "Package2", "10/03/2021");
		TreatmentPlan treatmentPlan= new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist", 
				12000, "In Progress", "10/03/2021", "10/04/2021");
		when(treatmentPlanRepository.getPlanUser(1)).thenReturn(treatmentPlan);
		iPTreatmentServiceImpl.updatePlan(1);
		verify(treatmentPlanRepository,times(1)).save(treatmentPlan);
		verify(treatmentPlanRepository,times(1)).getPlanUser(1);
		assertEquals("Completed",treatmentPlan.getStatus());
	}

}