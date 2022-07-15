package com.cognizant.insurance.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * @ExceptionHandler annotation is used for handling exceptions in specific
	 * handler classes and/or handler methods
	 * 
	 * to handle InsurerDetailNotFoundException
	 * 
	 * @param packageException
	 * @return proper message for exception
	 */
	@ExceptionHandler(InsurerDetailNotFoundException.class)
	public ResponseEntity<String> insurerDetailNotFoundExceptionHandler(InsurerDetailNotFoundException ex){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
		
	}
	
	/**
	 * @ExceptionHandler annotation is used for handling exceptions in specific
	 * handler classes and/or handler methods
	 * 
	 * to handle InvalidTokenException
	 * 
	 * @param invalidTokenException
	 * @return proper message for exception
	 */
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<String> insurerDetailNotFoundExceptionHandler(InvalidTokenException ex){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
		
	}
	

}
