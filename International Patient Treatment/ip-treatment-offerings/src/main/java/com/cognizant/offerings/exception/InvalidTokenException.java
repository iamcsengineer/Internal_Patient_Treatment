package com.cognizant.offerings.exception;


public class InvalidTokenException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTokenException() {
		super("The token is expired or wrong");
		
	}

}
