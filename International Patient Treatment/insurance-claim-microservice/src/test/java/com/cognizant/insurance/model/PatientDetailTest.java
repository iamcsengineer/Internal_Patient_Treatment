package com.cognizant.insurance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Patient Detail  
 *
 */
 class PatientDetailTest {

	PatientDetail patientDetail = new PatientDetail();

	@Test
	 void test_PatientDetail_LongStringIntStringStringString() {
		PatientDetail patientData = new PatientDetail(101, "Harry", 24, "Urology", "Package 1", "10/11/2020");
		assertEquals(101,patientData.getId());

	}

	@Test
	 void test_SetId() {
		patientDetail.setId(101);
		assertEquals(101,patientDetail.getId());

	}

	@Test
	 void test_GetId() {
		patientDetail.setId(101);
		assertEquals(101, patientDetail.getId());
	}

	@Test
	 void test_SetName() {
		patientDetail.setName("Harry");
		;
		assertEquals("Harry",patientDetail.getName());
	}

	@Test
	 void test_GetName() {

		patientDetail.setName("Harry");
		;
		assertEquals("Harry", patientDetail.getName());

	}

	@Test
	 void test_SetAge() {
		patientDetail.setAge(24);
		assertEquals(24,patientDetail.getAge());
	}

	@Test
	 void test_GetAge() {
		patientDetail.setAge(24);

		assertEquals(24, patientDetail.getAge());
	}

	@Test
	 void test_SetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology",patientDetail.getAilment());
	}

	@Test
	 void test_GetAilment() {
		patientDetail.setAilment("Urology");
		;
		assertEquals("Urology", patientDetail.getAilment());
	}

	@Test
	 void test_SetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1",patientDetail.getTreatmentPackageName());
	}

	@Test
	 void test_GetTreatmentPackageName() {
		patientDetail.setTreatmentPackageName("Package 1");
		assertEquals("Package 1", patientDetail.getTreatmentPackageName());
	}

	@Test
	 void test_SetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020",patientDetail.getTreatmentCommencementDate());
	}

	@Test
	 void test_GetTreatmentCommencementDate() {
		patientDetail.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", patientDetail.getTreatmentCommencementDate());
	}

}
