package com.project.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllowedContractTypes implements ConstraintValidator<ValidateContractType, String> {

	@Override
	public void initialize(ValidateContractType constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		List<String> contractType = Arrays.asList("fulltime", "parttime");

		return contractType.contains(value);
	}

}
