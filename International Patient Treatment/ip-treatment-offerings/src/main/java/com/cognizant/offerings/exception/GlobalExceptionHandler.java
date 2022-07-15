package com.cognizant.offerings.exception;

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
	 * to handle PackageDetailNotFoundException
	 * 
	 * @param packageException
	 * @return proper message for exception
	 */
	@ExceptionHandler(PackageDetailNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(PackageDetailNotFoundException packageException) {
		return new ResponseEntity<>(packageException.getMessage(), HttpStatus.NO_CONTENT);

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
	public ResponseEntity<String> insurerDetailNotFoundExceptionHandler(InvalidTokenException invalidTokenException) {

		return new ResponseEntity<>(invalidTokenException.getMessage(), HttpStatus.FORBIDDEN);

	}

}
