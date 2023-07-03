package com.project.exception;

public class InvalidDateException extends Exception {
	@Override
	public String toString() {
		String err = "INVALID Date :\n Required : > 1/1/2023";
		return err + "\n" + super.toString();
	}
}
