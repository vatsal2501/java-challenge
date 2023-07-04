package com.project.exception;

public class CustomException extends RuntimeException {

	private String message;
	private Integer httpStatus;

	public CustomException(String message, Integer httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

}
