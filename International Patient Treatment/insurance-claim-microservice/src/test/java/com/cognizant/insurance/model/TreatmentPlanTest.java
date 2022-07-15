package com.cognizant.insurance.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Treatment Plan  
 *
 */
 class TreatmentPlanTest {

	TreatmentPlan treatmentPlan = new TreatmentPlan();

	@Test
	 void test_SetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	 void test_GetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	 void test_SetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	 void test_GetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	 void test_SetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	 void test_GetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	 void test_SetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	 void test_GetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	 void test_SetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	 void test_GetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	 void test_SetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	 void test_GetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	 void test_SetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

	@Test
	 void test_GetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

}
