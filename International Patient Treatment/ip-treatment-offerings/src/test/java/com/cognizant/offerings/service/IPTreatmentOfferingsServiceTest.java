package com.cognizant.offerings.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.offerings.client.AuthClient;
import com.cognizant.offerings.exception.InvalidTokenException;
import com.cognizant.offerings.exception.PackageDetailNotFoundException;
import com.cognizant.offerings.model.AuthResponse;
import com.cognizant.offerings.model.IPTreatmentPackage;
import com.cognizant.offerings.model.PackageDetail;
import com.cognizant.offerings.model.SpecialistDetail;
import com.cognizant.offerings.repository.IPTreatmentOfferingsPackageDetailRepository;
import com.cognizant.offerings.repository.IPTreatmentOfferingsSpecialistDetailRepository;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 *
 *		@ExtendWith is a repeatable annotation that is used to register 
 *		extensions for the annotated test class or test method
 */
@ExtendWith(MockitoExtension.class)
public class IPTreatmentOfferingsServiceTest {

	/**
	 * @InjectMocks annotation can be used to inject mock fields into a test object automatically
	 */
	@Mock
	IPTreatmentOfferingsPackageDetailRepository ipTreatmentOfferingsRepository;

	@Mock
	IPTreatmentOfferingsSpecialistDetailRepository ipTreatmentOfferingsSpecialistDetaiLRepository;

	@Mock
	AuthClient authClient;

	@InjectMocks
	IPTreatmentOfferingsServiceImpl ipTreatmentOfferingsServiceImpl;

	/**
	 * to test validation of token
	 */
	@Test
	public void test_ValidateToken() {
		when(authClient.verifyToken("token")).thenReturn(new AuthResponse("id", "name", true));
		assertEquals("name", ipTreatmentOfferingsServiceImpl.validateToken("token").getName());
	}

	/**
	 * to test validate token with invalid token
	 */
	@Test
	public void test_ValidateTokenWithInvalidToken() {
		when(authClient.verifyToken("token")).thenReturn(new AuthResponse("id", "name", false));
		assertThrows(InvalidTokenException.class, () -> ipTreatmentOfferingsServiceImpl.validateToken("token"));
	}

	/**
	 * to test validate token throwing exception
	 */
	@Test
	public void test_ValidateTokenThrowsException() {
		when(authClient.verifyToken("token")).thenThrow(RuntimeException.class);
		assertThrows(InvalidTokenException.class, () -> ipTreatmentOfferingsServiceImpl.validateToken("token"));
	}

	/**
	 * to test that all IP treatment packages are fetched properly
	 */
	@Test
	public void test_GetIPTreatmentPackages() {
		List<IPTreatmentPackage> ipTreatmentPackages = new ArrayList<IPTreatmentPackage>();
		PackageDetail packageDetail=new PackageDetail("Package 1", "UTP 1,UTP 2", 12000, 4);
		IPTreatmentPackage ipTreatmentPackage= new IPTreatmentPackage(1, "Urology", packageDetail);
		ipTreatmentPackages.add(ipTreatmentPackage);
		when(ipTreatmentOfferingsRepository.findAll()).thenReturn(ipTreatmentPackages);
		assertEquals(ipTreatmentPackages, ipTreatmentOfferingsServiceImpl.getIPTreatmentPackages());
	}
	
	/**
	 * to test that IP treatment package based on ailment category
	 * and package name is fetched properly
	 */
	@Test
	public void test_GetIPTreatmentPackageByAilmentCategoryAndName() {
		PackageDetail packageDetail1=new PackageDetail("Package 1", "UTP1, UTP2", 25000, 4);
		PackageDetail packageDetail2=new PackageDetail("Package 2", "OTP1, OTP2", 18000, 6);
		IPTreatmentPackage iPTreatmentPackage1 = new IPTreatmentPackage(45, "Urology", packageDetail1);
		IPTreatmentPackage iPTreatmentPackage2 = new IPTreatmentPackage(48, "Orthopaedics", packageDetail2);
//Orthopaedics	18000	OPT1, OPT2	6	Package 2
		//private String treatmentPackageName;
		//private String testDetails;
		//private int cost;
		//private int treatmentDurationInWeeks;
		when(ipTreatmentOfferingsRepository.findByName("Package 1", "Urology")).thenReturn(iPTreatmentPackage1);
		when(ipTreatmentOfferingsRepository.findByName("Package 2", "Orthopaedics")).thenReturn(iPTreatmentPackage2);
		when(ipTreatmentOfferingsRepository.findByName("Package 22", "Urology")).thenReturn(null);
		assertEquals(iPTreatmentPackage1,
				ipTreatmentOfferingsServiceImpl.getIPTreatmentPackageByAilmentCategoryAndName("package1", "Urology"));
		assertEquals(iPTreatmentPackage2,
				ipTreatmentOfferingsServiceImpl.getIPTreatmentPackageByAilmentCategoryAndName("package2", "Orthopaedics"));

		assertThrows(PackageDetailNotFoundException.class,
				() -> ipTreatmentOfferingsServiceImpl.getIPTreatmentPackageByAilmentCategoryAndName("Package 22", "Urology"));
	}

	/**
	 * to test that all specialist details are fetched properly
	 */
	@Test
	public void test_GetSpecialists() {
		List<SpecialistDetail> specialistDetails = new ArrayList<SpecialistDetail>();
		SpecialistDetail specialistDetail=new SpecialistDetail(1, "Dr. Varun Mehta", "Orthopaedics", 12, "9876543210");
		specialistDetails.add(specialistDetail);
		when(ipTreatmentOfferingsSpecialistDetaiLRepository.findAll()).thenReturn(specialistDetails);
		assertEquals(specialistDetails, ipTreatmentOfferingsServiceImpl.getSpecialists());

	}

}