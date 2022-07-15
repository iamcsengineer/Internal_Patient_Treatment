package com.cognizant.offerings.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;




/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the IP Treatment Package  
 *
 */
public class IPTreatmentPackageTest {

	IPTreatmentPackage ipTreatment = new IPTreatmentPackage();

	@Test
	public void test_IPTreatmentPackageDetail_LongStringPackage() {
		PackageDetail detail = new PackageDetail();
		IPTreatmentPackage treatment = new IPTreatmentPackage(101, "Urology", detail);

		assertEquals(101,treatment.getId());
	}

	@Test
	public void test_SetId() {
		ipTreatment.setId(10);
		assertEquals(10,ipTreatment.getId());
	}

	@Test
	public void test_GetId() {
		ipTreatment.setId(10);
		assertEquals(10, ipTreatment.getId());

	}

	@Test
	public void test_SetAilmentCategory() {
		ipTreatment.setAilmentCategory("Urology");
		assertEquals("Urology",ipTreatment.getAilmentCategory());
	}

	@Test
	public void test_GetAilmentCategory() {
		ipTreatment.setAilmentCategory("Urology");
		assertEquals("Urology", ipTreatment.getAilmentCategory());
	}

	@Test
	public void test_SetPackageDetail() {
		PackageDetail detail = new PackageDetail();
		ipTreatment.setPackageDetail(detail);
		assertEquals(detail,ipTreatment.getPackageDetail());
	}

	@Test
	public void test_GetPackageDetail() {
		PackageDetail detail = new PackageDetail();
		ipTreatment.setPackageDetail(detail);
		assertEquals(detail, ipTreatment.getPackageDetail());
	}

}
