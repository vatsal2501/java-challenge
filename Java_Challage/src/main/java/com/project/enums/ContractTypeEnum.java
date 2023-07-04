package com.project.enums;

public enum ContractTypeEnum {
	
	FULLTIME("fulltime"), PARTTIME("parttime");

	private String value;

	private ContractTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
