package com.cts.nasa.nasaservice.exception;

public class ImageNotFoundException extends RuntimeException{
	
	public ImageNotFoundException(String message) {
		super(message);
		
	}
	
	public ImageNotFoundException(String message, Throwable cause) {
		super(message,cause);
		
	}

}
