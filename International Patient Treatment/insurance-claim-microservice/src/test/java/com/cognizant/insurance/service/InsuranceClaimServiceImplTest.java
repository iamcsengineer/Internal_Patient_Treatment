package com.cognizant.insurance.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.insurance.client.AuthClient;
import com.cognizant.insurance.client.FeignCallService;
import com.cognizant.insurance.exception.InsurerDetailNotFoundException;
import com.cognizant.insurance.exception.InvalidTokenException;
import com.cognizant.insurance.model.AuthResponse;
import com.cognizant.insurance.model.InitiateClaim;
import com.cognizant.insurance.model.InsurerDetail;
import com.cognizant.insurance.model.PatientDetail;
import com.cognizant.insurance.model.TreatmentPlan;
import com.cognizant.insurance.repository.InitiateClaimRepository;
import com.cognizant.insurance.repository.InsurerDetailRepository;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 *
 *		@ExtendWith is a repeatable annotation that is used to register 
 *		extensions for the annotated test class or test method
 */
@ExtendWith(MockitoExtension.class)
class InsuranceClaimServiceImplTest {
	
	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object automatically
	 */
	@Mock
	InsurerDetailRepository insurerDetailRepository;
	
	@Mock
	InitiateClaimRepository initiateClaimRepository;
	
	@InjectMocks
	InsuranceClaimServiceImpl insuranceClaimServiceImpl;
	
	@Mock
	AuthClient authClient;
	
	@Mock
	FeignCallService feignCallService;
	
	/**
	 * to test that the list of all insurer details are fetched properly
	 */
	@Test
	 void test_GetAllInsurerDetail() {
		List<InsurerDetail> insurerDetailList = new ArrayList<InsurerDetail>();
		insurerDetailList.add(new InsurerDetail(0l, "Life Insurance Corporation", "Individual Health Plan", 4000, 10));
		when(insurerDetailRepository.findAll()).thenReturn(insurerDetailList);
		assertEquals( "Individual Health Plan",insuranceClaimServiceImpl.getAllInsurerDetail().get(0).getInsurerPackageName());
	}
	
	/**
	 * to test failure in getting the list of all insurer details 
	 */
	@Test
	 void test_GetAllInsurerDetailFailed() {
		when(insurerDetailRepository.findAll()).thenThrow(new RuntimeException());
		assertThrows(InsurerDetailNotFoundException.class, ()->insuranceClaimServiceImpl.getAllInsurerDetail());
	}
	
	/**
	 * to test that the insurer details are fetched properly
	 */
	@Test
	 void test_GetInsurerDetail() {
		Optional<InsurerDetail> ins=Optional.of(new InsurerDetail(0, "Life Insurance Corporation", "Individual Health Plan", 4000, 10));
		when(insurerDetailRepository.findById(0l)).thenReturn(ins);
		assertEquals( "Individual Health Plan",insuranceClaimServiceImpl.getInsurerDetail("Individual Health Plan").getInsurerPackageName());
	}

	/**
	 * to test the failure in fetching the insurer details
	 */
	@Test
	 void test_GetInsurerDetailFailed() {
		Optional<InsurerDetail> ins=Optional.empty();
		when(insurerDetailRepository.findById(0l)).thenReturn(ins);
		assertThrows( InsurerDetailNotFoundException.class, ()-> insuranceClaimServiceImpl.getInsurerDetail("Individual Health Plan").getInsurerPackageName());	
	}
	
	/**
	 * to test the functioning of initiating claim
	 */
	@Test
	 void test_InitiateClaim() {
		PatientDetail patientDetail=new PatientDetail(1, "John", 25, "Arthristis", "Package2", "10/03/2021");
		List<TreatmentPlan> treatmentPlanList=new ArrayList<TreatmentPlan>();
		treatmentPlanList.add(new TreatmentPlan(1, patientDetail, "Test1", "Package2", "Junior Specialist", 18000, "In Progress", "10/03/2021", "10/04/2021"));
		when(feignCallService.getAllPlans("token")).thenReturn(treatmentPlanList);
		InsurerDetail insurerDetail= new InsurerDetail(1, "Life Insurance Corporation", "Individual Health Plan", 4000, 10);
		List<InsurerDetail> insurerDetailList= new ArrayList<InsurerDetail>();
		insurerDetailList.add(insurerDetail);
		InitiateClaim initiateClaim = new InitiateClaim(1, "John", "Arthritis", "Package2", "Life Insurance Corporation");
		when(insurerDetailRepository.findAll()).thenReturn(insurerDetailList);
		assertEquals(14000,insuranceClaimServiceImpl.initiateClaim("token", initiateClaim));
	}

	/**
	 * to test validation of token
	 */
	@Test
	 void test_ValidateToken() {
		when( authClient.verifyToken("token")).thenReturn(new AuthResponse("id", "name", true));
		assertEquals( "name",insuranceClaimServiceImpl.validateToken("token").getName());
	}
	
	/**
	 * to test validation of invalid token
	 */
	@Test
	 void test_ValidateTokenWithInvalidToken() {
		when( authClient.verifyToken("token")).thenReturn(new AuthResponse("id", "name", false));
		assertThrows( InvalidTokenException.class, ()->insuranceClaimServiceImpl.validateToken("token"));
	}
	
	/**
	 * to test validate token throwing exception
	 */
	@Test
	 void test_ValidateTokenThrowsException() {
		when( authClient.verifyToken("token")).thenThrow(RuntimeException.class);
		assertThrows( InvalidTokenException.class, ()->insuranceClaimServiceImpl.validateToken("token"));
	}

}