package com.project.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//TODO: validation contract :: 
/**annotation is not working for instance*/

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AllowedContractTypes.class)
public @interface ValidateContractType {
	public String message() default "Invalid Contract Type found: required : fulltime / parttime";
	
	Class<?>[] groups() default {};

	  Class<? extends Payload>[] payload() default {};
}
