package com.project.enums;

public enum GenderEnum {

	MALE("male"), FEMALE("female");

	private String value;

	private GenderEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}


}
