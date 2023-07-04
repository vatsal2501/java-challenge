package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.validation.ValidateContractType;

@Entity
@Table(name = "account_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "person_details")
	private PersonDetail personDetails;

	@Column(name = "account_ype")
	private String accountType;

	@Column(name = "business_requirements")
	private String[] businessRequirements;

	@Column(name = "contract_type")
	private String contractType;

	private boolean status = true;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public PersonDetail getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetail personDetails) {
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

	public String getContractType() {
		return contractType;
	}
	
	public void setContractType(String contractType) {
		this.contractType = contractType; 
	}

}
