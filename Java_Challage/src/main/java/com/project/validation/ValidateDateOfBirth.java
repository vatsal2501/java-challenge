package com.project.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//TODO: validation date of birth :: 
/**annotation is not working for instance*/

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AllowedDOB.class)
public @interface ValidateDateOfBirth {
	
	public String message() default "Invalid date of birth: required : < 01/01/2002";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
