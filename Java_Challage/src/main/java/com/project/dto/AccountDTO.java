package com.project.dto;

import java.io.Serializable;

import com.project.enums.ContractTypeEnum;
import com.project.validation.ValueOfEnum;
import com.sun.istack.NotNull;

public class AccountDTO implements Serializable {

	private int id;
	
	private String name;

	private PersonDetailDTO personDetails;
	
	private String accountType;

	private String[] businessRequirements;

//	@ValueOfEnum(enumClass = ContractTypeEnum.class)
	private String contractType;

	private boolean status = true;
	
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonDetailDTO getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetailDTO personDetails) {
		this.personDetails = personDetails;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String[] getBusinessRequirements() {
		return businessRequirements;
	}

	public void setBusinessRequirements(String[] businessRequirements) {
		this.businessRequirements = businessRequirements;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
