package com.konman.clipper.utility;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.konman.clipper.model.UserNotFoundResponse;

@ControllerAdvice
public class UserRestExceptionHandler {

	
	// Function to throw the error Response when User Not Found
	@ExceptionHandler
	public ResponseEntity<UserNotFoundResponse>  handleException(UserNotFoundException exception){
		
		UserNotFoundResponse error = new UserNotFoundResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		ClipperUtility.clipperLogger.info("Throwing User Not Found Exception");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Function to throw the error Response for general erro
	@ExceptionHandler
	public ResponseEntity<UserNotFoundResponse> handleException(Exception exception) {
		
		UserNotFoundResponse error = new UserNotFoundResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		ClipperUtility.clipperLogger.info("Throwing General Exception");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
}
