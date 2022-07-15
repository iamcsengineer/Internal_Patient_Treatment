package com.cognizant.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Package Detail  
 *
 */
public class PackageDetailTest {

	PackageDetail packageDetail = new PackageDetail();

	@Test
	public void test_PackageDetail_StringStringIntInt() {
		PackageDetail detail = new PackageDetail("Package 1", "Urology", 1000, 4);
		assertEquals(1000,detail.getCost());
	}

	@Test
	public void test_PackageDetail() {
		PackageDetail detail = new PackageDetail();
		detail.setTestDetails("Urology");
		assertEquals("Urology",detail.getTestDetails());
	}

	@Test
	public void test_TreatmentPackageName() {
		packageDetail.setTreatmentPackageName("Package 3");
		assertEquals("Package 3",packageDetail.getTreatmentPackageName());
	}

	@Test
	public void test_TestDetails() {
		packageDetail.setTestDetails("OPT1,0PT3");
		assertEquals("OPT1,0PT3",packageDetail.getTestDetails());
	}

	@Test
	public void test_Cost() {
		packageDetail.setCost(5000);
		assertEquals(5000,packageDetail.getCost());
	}

	@Test
	public void test_TreatmentDuration() {
		packageDetail.setTreatmentDurationInWeeks(4);
		assertEquals(4,packageDetail.getTreatmentDurationInWeeks());
	}

	@Test
	public void test_toString() {
		String string = packageDetail.toString();
		assertEquals(string,packageDetail.toString());
	}

}
