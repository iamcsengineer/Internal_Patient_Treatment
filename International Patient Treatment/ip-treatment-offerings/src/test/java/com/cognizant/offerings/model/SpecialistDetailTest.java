package com.cognizant.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Specialist Detail  
 *
 */
public class SpecialistDetailTest {
	
	SpecialistDetail specialistDetail=new SpecialistDetail();
	

	@Test
	public void test_SpecialistDetail_LongStringStringIntString() {
		SpecialistDetail specialistDetail=new SpecialistDetail(1, "Dr. XYZ", "Urology", 5, "1234567890");
		assertEquals("Dr. XYZ",specialistDetail.getName());
		
	}

	@Test
	public void test_SetId() {
		specialistDetail.setId(101);
		assertEquals(101,specialistDetail.getId());
	}
	

	@Test
	public void test_GetId() {
		specialistDetail.setId(101);
		assertEquals(101,specialistDetail.getId());
	}

	@Test
	public void test_SetName() {
		specialistDetail.setName("Dr. XYZ");
		assertEquals("Dr. XYZ",specialistDetail.getName());
	}
	
	@Test
	public void test_GetName() {
		specialistDetail.setName("Dr. XYZ");
		assertEquals("Dr. XYZ",specialistDetail.getName());
	}
	
	@Test
	public void test_SetAreaOfExpertise() {
		specialistDetail.setAreaOfExpertise("Urology");
		assertEquals("Urology",specialistDetail.getAreaOfExpertise());
	}

	@Test
	public void test_GetAreaOfExpertise() {
		specialistDetail.setAreaOfExpertise("Urology");
		assertEquals("Urology",specialistDetail.getAreaOfExpertise());
		
	}
	
	@Test
	public void test_SetExperienceInYears() {
		specialistDetail.setExperienceInYears(10);
		assertEquals(10,specialistDetail.getExperienceInYears());
	}

	@Test
	public void test_GetExperienceInYears() {
		specialistDetail.setExperienceInYears(10);
		assertEquals(10,specialistDetail.getExperienceInYears());
	}

	@Test
	public void test_SetContactNumber() {
		specialistDetail.setContactNumber("1234567890");
		assertEquals("1234567890",specialistDetail.getContactNumber());
	}
	
	@Test
	public void test_GetContactNumber() {
		specialistDetail.setContactNumber("1234567890");
		assertEquals("1234567890",specialistDetail.getContactNumber());
	}

}
