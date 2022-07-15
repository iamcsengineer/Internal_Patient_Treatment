package com.cognizant.treatments.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Patient Detail  
 *
 */
public class PatientDetailTest {

	PatientDetail patientDetail = new PatientDetail();

	@Test
	public void test_PatientDetail_LongStringIntStringStringString() {
		PatientDetail patientData = new PatientDetail(101, "Harry", 24, "Urology", "Package 1", "10/11/2020");
		assertEquals(101,patientData.getId());

	}

	@Test
	public void test_SetId() {
		patientDetail.setId(101);
		assertEquals(101,patientDetail.getId());

	}

	@Test
	public void test_GetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());
	}

	@Test
	public void test_SetName() {
		patientDetail.setName("Harry");
		;
		assertEquals("Harry",patientDetail.getName());
	}

	@Test
	public void test_GetName() {

		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());

	}

	@Test
	public void test_SetAge() {
		patientDetail.setAge(24);
		assertEquals(24,patientDetail.getAge());
	}

	@Test
	public void test_GetAge() {
		patientDetail.setAge(24);

		assertEquals(24, patientDetail.getAge());
	}

	@Test
	public void test_SetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology",patientDetail.getAilment());
	}

	@Test
	public void test_GetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	@Test
	public void test_SetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1",patientDetail.getTreatmentPackageName());
	}

	@Test
	public void test_GetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	@Test
	public void test_SetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020",patientDetail.getTreatmentCommencementDate());
	}

	@Test
	public void test_GetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

}
