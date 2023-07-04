package com.project.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllowedGender implements ConstraintValidator<ValidateGender, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		System.out.println(":: in annotation gender ::");
		List<String> genders = Arrays.asList("female","male");
		
		return  genders.contains(value);
	}

	@Override
	public void initialize(ValidateGender constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

}
