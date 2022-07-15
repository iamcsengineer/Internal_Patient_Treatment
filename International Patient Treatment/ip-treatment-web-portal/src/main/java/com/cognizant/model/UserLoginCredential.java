package com.cognizant.model;

public class UserLoginCredential {
	private String uid;
	private String password;
	public String getUid() {
		return uid;
	}
	public void setUid(String id) {
		this.uid = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserLoginCredential(String id, String password) {
		super();
		this.uid = id;
		this.password = password;
	}
	public UserLoginCredential() {
		super();
	}
	

}
