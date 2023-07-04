package com.project.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



//TODO: validation gender :: 
/**annotation is not working for instance*/

@Target({ElementType.FIELD , ElementType.PARAMETER} )
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AllowedGender.class) 
public @interface ValidateGender{
	
	public String message() default "Invalid gender found: required : male / female";
	
	  Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};
}
