package com.student.management.exception;

public class StudentManagementBusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StudentManagementBusinessException() {
		super();
	}

	public StudentManagementBusinessException(String message) {
		super(message);
		this.message = message;
	}

	public StudentManagementBusinessException(Throwable message) {
		super(message);
	}

	@Override
	public String toString() {
		return message;

	}

}