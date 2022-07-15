package com.cognizant.offerings.exception;


public class PackageDetailNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PackageDetailNotFoundException(String packageName) {
		super("There is no package with- "+packageName);
	}
	
	public PackageDetailNotFoundException(){
		
	}

	
}
