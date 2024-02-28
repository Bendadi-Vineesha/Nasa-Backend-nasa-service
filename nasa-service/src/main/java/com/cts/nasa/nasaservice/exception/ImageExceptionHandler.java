package com.cts.nasa.nasaservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ImageExceptionHandler {
	
	 @ExceptionHandler(value = {ImageNotFoundException.class})
	    public ResponseEntity<Object> handleImageNotFoundException
	            (ImageNotFoundException imageNotFoundException)
	    {
		 ImageException imageExceptionException = new ImageException(
	                imageNotFoundException.getMessage(),
	                imageNotFoundException.getCause(),
	                HttpStatus.NOT_FOUND
	        );

	        return new ResponseEntity<>(imageExceptionException, HttpStatus.NOT_FOUND);
	    }

}
