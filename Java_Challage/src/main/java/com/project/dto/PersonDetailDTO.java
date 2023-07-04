package com.project.dto;

import com.project.enums.GenderEnum;
import com.project.validation.ValidateDateOfBirth;
import com.project.validation.ValueOfEnum;

public class PersonDetailDTO {
	
//	@ValueOfEnum(enumClass = GenderEnum.class)
	private String gender;

//	@ValidateDateOfBirth
	private String dob;
	
	private String nativePlace;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
}
