package com.user.services.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource Not Found On Server !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
