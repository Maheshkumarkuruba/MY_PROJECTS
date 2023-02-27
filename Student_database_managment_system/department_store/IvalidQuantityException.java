package com.jsp.department;

public class IvalidQuantityException extends Exception {
	String message;
	public IvalidQuantityException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
}
