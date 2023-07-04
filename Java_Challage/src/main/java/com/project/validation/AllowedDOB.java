package com.project.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AllowedDOB implements ConstraintValidator<ValidateDateOfBirth, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean flag = false;
		
		System.out.println(":: In datevalidation ::");
		String date_String = "01-01-2002";
		
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date dateLimit = formater.parse(date_String);
			Date date =formater.parse(value);

			if (date.before(dateLimit)) {
				flag = true;
			} else if (date.equals(dateLimit)) {
				flag = true;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public void initialize(ValidateDateOfBirth constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

}
