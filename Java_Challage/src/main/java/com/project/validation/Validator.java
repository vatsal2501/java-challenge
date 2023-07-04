package com.project.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import com.project.enums.ContractTypeEnum;
import com.project.enums.ExceptionEnum;
import com.project.enums.GenderEnum;
import com.project.exception.CustomException;

//TODO: validate date, gender, contract
public class Validator{
	
	//TODO: validation gender
	public static boolean validateGender(String gender) {
		boolean flag=true;
		
		final List<String> genderAcceptabledValues = EnumSet.allOf(GenderEnum.class)
															.stream()
															.map(e -> e.getValue())
															.collect(Collectors.toList());
		
		if (!genderAcceptabledValues.contains(gender)) {
			
			flag=false;
			
		}
		return flag;
	}
	
	//TODO: validation contract
	public static boolean validateContractType(String contractType) {
		boolean flag=true;
		
		final List<String> contractAcceptableValues = EnumSet.allOf(ContractTypeEnum.class)
															.stream()
															.map(e -> e.getValue())
															.collect(Collectors.toList());
		
		if (!contractAcceptableValues.contains(contractType)) {
			
			flag = false;
			
		} 

		return flag;
	}
	
	//TODO: validation date of birth
	public static boolean validateDob(String dateValue) throws ParseException {

		final String date_String = "01-01-2002";
		boolean flag = false;
		
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dateLimit = formater.parse(date_String);
			Date date =formater.parse(dateValue);
			
			System.out.println("////////////////////" +dateLimit +" ::  "  + date );
			
			System.out.println("////////////////////" +date.before(dateLimit)+ " ///////// " +date.equals(dateLimit));
			
			if (date.before(dateLimit) || date.equals(dateLimit)) {
				flag = true;
			}

		} catch (ParseException e) {
			
			System.out.println("////////// test in catch block of date ");
			throw e;
		
		}
		 
		return flag;
		
	}
	
}
