package com.nareshit.exceptionmapper;

import org.springframework.stereotype.Controller;


public class CustomExceptionMapper extends RuntimeException {
	
	private String message;
	private int statusCode;
	public CustomExceptionMapper(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	/*public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}*/
	

}
