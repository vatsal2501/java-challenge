package com.project.enums;

public enum ExceptionEnum {
	

	INVALID_CONTRACT_TYPE(101, "Contract type is not valid"),
	
	INVALID_GENDER_TYPE(102, "Gender type is not valid"),

	INVALID_DATE(103,"Date is not in required rang"),

	NO_ACCOUNT_AVAILBLE(104,"There is no account in database"),
	
	INVALID_ID(105, "Required Integer parameter 'accountId' is not present");
	
	private int statusCode;
	private String message;

	private ExceptionEnum(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

}
