package com.cognizant.insurance.exception;


public class InvalidTokenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTokenException() {
		super("the token is expired or wrong");
		
	}

}
