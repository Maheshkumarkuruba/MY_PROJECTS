package com.jsp.department;

public class IvalidException extends Exception{

	String message;
	public IvalidException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
}
