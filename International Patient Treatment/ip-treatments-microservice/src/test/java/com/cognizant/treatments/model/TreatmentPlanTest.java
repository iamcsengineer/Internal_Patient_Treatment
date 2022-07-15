package com.cognizant.treatments.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Treatment Plan  
 *
 */
public class TreatmentPlanTest {

	TreatmentPlan treatmentPlan = new TreatmentPlan();

	@Test
	public void test_SetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	public void test_GetId() {
		treatmentPlan.setId(10);
		assertEquals(10, treatmentPlan.getId());
	}

	@Test
	public void test_SetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	public void test_GetTestDetails() {
		treatmentPlan.setTestDetails("Urology");
		assertEquals("Urology", treatmentPlan.getTestDetails());
	}

	@Test
	public void test_SetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	public void test_GetPackageName() {
		treatmentPlan.setPackageName("Package 1");
		assertEquals("Package 1", treatmentPlan.getPackageName());
	}

	@Test
	public void test_SetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}

	@Test
	public void test_GetSpecialist() {
		treatmentPlan.setSpecialist("Orthopeadics");
		assertEquals("Orthopeadics", treatmentPlan.getSpecialist());
	}
	
	@Test
	public void test_SetCost() {
		treatmentPlan.setCost(5000);
		assertEquals(5000, treatmentPlan.getCost());
	}

	@Test
	public void test_GetCost() {
		treatmentPlan.setCost(5000);
		assertEquals(5000, treatmentPlan.getCost());
	}

	@Test
	public void test_SetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	public void test_GetStatus() {
		treatmentPlan.setStatus("In progress");
		assertEquals("In progress", treatmentPlan.getStatus());
	}

	@Test
	public void test_SetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	public void test_GetTreatmentCommencementDate() {
		treatmentPlan.setTreatmentCommencementDate("10/11/2020");
		assertEquals("10/11/2020", treatmentPlan.getTreatmentCommencementDate());
	}

	@Test
	public void test_SetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

	@Test
	public void test_GetTreatmentEndDate() {
		treatmentPlan.setTreatmentEndDate("10/12/2020");
		assertEquals("10/12/2020", treatmentPlan.getTreatmentEndDate());
	}

}
