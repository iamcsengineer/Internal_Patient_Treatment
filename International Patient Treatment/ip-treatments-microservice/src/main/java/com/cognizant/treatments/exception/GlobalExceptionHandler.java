package com.cognizant.treatments.exception;

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
	 * to handle UserNotFoundException
	 * 
	 * @param userNotFoundException
	 * @return proper message for exception
	 */

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);

	}

}