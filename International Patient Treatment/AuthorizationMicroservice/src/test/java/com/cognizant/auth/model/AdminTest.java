package com.cognizant.auth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



/**
 * 
 * @author Pratik, Shubham, Pratik, Kavya
 * 
 * 		the class tests all the setters and getters and constructors
 * 		for the admin details 
 *
 */

public class AdminTest {

	Admin admin = new Admin();
	
	@Test
	public void test_SetUserId() {
		admin.setUserid("1");
		assertEquals("1", admin.getUserid());
	}

	@Test
	public void test_GetUserId() {
		admin.setUserid("1");
		assertEquals("1", admin.getUserid());
	}
	
	@Test
	public void test_SetUserName() {
		admin.setUname("admin");
		assertEquals("admin", admin.getUname());
	}

	@Test
	public void test_GetUserName() {
		admin.setUname("admin");
		assertEquals("admin", admin.getUname());
	}
	
	@Test
	public void test_SetUserPassword() {
		admin.setUpassword("password");
		assertEquals("password", admin.getUpassword());
	}

	@Test
	public void test_GetUserPassword() {
		admin.setUpassword("password");
		assertEquals("password", admin.getUpassword());
	}
	
	@Test
	public void test_SetAuthToken() {
		admin.setAuthToken("authToken");
		assertEquals("authToken", admin.getAuthToken());
	}

	@Test
	public void test_GetAuthToken() {
		admin.setAuthToken("authToken");
		assertEquals("authToken", admin.getAuthToken());
	}
	
	@Test
	public void test_Admin_StringStringStringString() {
		Admin admin = new Admin("userid", "upassword", "uname", "authToken");
		assertEquals("uname", admin.getUname());
	}
	
	
}
