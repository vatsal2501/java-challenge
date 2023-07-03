package com.project.exception;

public class InavlidGenderException extends Exception {
	@Override
	public String toString() {
		String err = "INVALID Gender :\n Required : male / female";
		return err + "\n" + super.toString();
	}
}
