package com.cognizant.insurance.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Pratik K, Pratik B, Shubham, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the Authorization response  
 *
 */
 class AuthResponseTest {

	AuthResponse authResponse = new AuthResponse();

	@Test
	 void test_SetUid() {
		authResponse.setUid("1");
		assertEquals("1", authResponse.getUid());
	}

	@Test
	 void test_GetUid() {
		authResponse.setUid("1");
		assertEquals("1", authResponse.getUid());
	}

	@Test
	 void test_SetName() {
		authResponse.setName("Admin");
		assertEquals("Admin", authResponse.getName());
	}

	@Test
	 void test_GetName() {
		authResponse.setName("Admin");
		assertEquals("Admin", authResponse.getName());
	}

	@Test
	 void test_SetValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

	@Test
	 void test_IsValid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

	@Test
	 void test_AuthResponse_StringStringBoolean() {
		AuthResponse authrespo = new AuthResponse("1", "Admin", true);
		assertEquals("Admin", authrespo.getName());
	}
}
