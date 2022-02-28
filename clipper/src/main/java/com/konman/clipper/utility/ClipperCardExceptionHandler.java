package com.konman.clipper.utility;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.konman.clipper.model.ClipperCardErrorResponse;
import com.konman.clipper.model.UserErrorResponse;

@ControllerAdvice
public class ClipperCardExceptionHandler {

	
	// Function to throw the error Response when User Not Found
	@ExceptionHandler
	public ResponseEntity<ClipperCardErrorResponse>  handleException(ClipperCardException exception){
		
		ClipperCardErrorResponse error = new ClipperCardErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		ClipperUtility.clipperLogger.info("Throwing User Not Found Exception");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
}
