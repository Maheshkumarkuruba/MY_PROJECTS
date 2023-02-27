package com.jsp.customexception;

public class StudentNotFoundException extends RuntimeException {
	String message;
	public  StudentNotFoundException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

}
