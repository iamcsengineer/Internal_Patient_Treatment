package com.cognizant.offerings.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cognizant.offerings.client.AuthClient;
import com.cognizant.offerings.model.AuthResponse;
import com.cognizant.offerings.model.IPTreatmentPackage;
import com.cognizant.offerings.model.PackageDetail;
import com.cognizant.offerings.model.SpecialistDetail;
import com.cognizant.offerings.service.IPTreatmentOfferingsServiceImpl;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 *
 *         With the @SpringBootTest annotation, Spring Boot provides a
 *         convenient way to start up an application context to be used in a test
 * 		   @AutoConfigureMockMvc can be applied to a test class to enable and configure
 *         auto-configuration of MockMvc
 */
@AutoConfigureMockMvc
@SpringBootTest
public class IPTreatmentOfferingsControllerTest {

	/**
	 * @MockBean allow to mock a class or an interface and to record and verify
	 * behaviors on it
	 */
	@MockBean
	AuthClient authClient;

	@Autowired
	MockMvc mockMvc;

	@MockBean
	IPTreatmentOfferingsServiceImpl ipTreatmentOfferingsServiceImpl;

	/**
	 * to test that all IP treatment packages are fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetIPTreatmentPackages() throws Exception {
		PackageDetail packageDetail = new PackageDetail("Package1", "UTP1,UTP2", 15000, 4);
		List<IPTreatmentPackage> ipTreatmentPackages = new ArrayList<IPTreatmentPackage>();
		ipTreatmentPackages.add(new IPTreatmentPackage(1, "Urology", packageDetail));
		when(ipTreatmentOfferingsServiceImpl.getIPTreatmentPackages()).thenReturn(ipTreatmentPackages);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result = mockMvc.perform(get("/iptms/iptreatmentpackages").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "[{\"id\":1,\"ailmentCategory\":\"Urology\",\"packageDetail\":{\"treatmentPackageName\":\"Package1\",\"testDetails\":\"UTP1,UTP2\",\"cost\":15000,\"treatmentDurationInWeeks\":4}}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test that IP treatment package based on ailment category
	 * and package name is fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetIPTreatmentPackageByAilmentCategoryAndName() throws Exception {
		PackageDetail packageDetail = new PackageDetail("Package1", "UTP1,UTP2", 15000, 4);
		IPTreatmentPackage ipTreatmentPackage = new IPTreatmentPackage(1, "Urology", packageDetail);
		when(ipTreatmentOfferingsServiceImpl.getIPTreatmentPackageByAilmentCategoryAndName("Package1", "Urology"))
				.thenReturn(ipTreatmentPackage);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result = mockMvc
				.perform(
						get("/iptms/iptreatmentpackagebyname/Urology/Package1").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "{\"id\":1,\"ailmentCategory\":\"Urology\",\"packageDetail\":{\"treatmentPackageName\":\"Package1\",\"testDetails\":\"UTP1,UTP2\",\"cost\":15000,\"treatmentDurationInWeeks\":4}}";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

	/**
	 * to test that all specialist details are fetched properly
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_GetSpecialists() throws Exception {
		List<SpecialistDetail> specialistDetailsList = new ArrayList<SpecialistDetail>();
		specialistDetailsList.add(new SpecialistDetail(1, "Dr. AK Garg", "Orthopaedics", 12, "9876543210"));
		when(ipTreatmentOfferingsServiceImpl.getSpecialists()).thenReturn(specialistDetailsList);
		when(authClient.verifyToken("Bearer Token")).thenReturn(new AuthResponse("admin1", "admin1", true));
		MvcResult result = mockMvc.perform(get("/iptms/specialists").header("Authorization", "Bearer Token"))
				.andReturn();
		String expected = "[{\"id\":1,\"name\":\"Dr. AK Garg\",\"areaOfExpertise\":\"Orthopaedics\",\"experienceInYears\":12,\"contactNumber\":\"9876543210\"}]";
		String actual = result.getResponse().getContentAsString();
		assertEquals(expected, actual);
	}

}