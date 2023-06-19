package com.masai.exceptions;

public class DuplicateDataException extends Exception {

	public DuplicateDataException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "" + getMessage();
	}

}
