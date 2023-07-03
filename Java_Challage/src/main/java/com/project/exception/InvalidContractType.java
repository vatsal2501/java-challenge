package com.project.exception;

public class InvalidContractType extends Exception {
	@Override
	public String toString() {
		String err = "INVALID ContractType :\n Required : fulltime / parttime";
		return err + "\n" + super.toString();
	}
}
