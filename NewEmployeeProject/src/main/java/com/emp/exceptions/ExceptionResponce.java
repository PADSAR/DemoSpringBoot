package com.emp.exceptions;

import java.time.LocalDateTime;

public class ExceptionResponce {
	private String msg;
	private String errorCode;
	private LocalDateTime timeStanmp;
	public ExceptionResponce(String msg, String errorCode, LocalDateTime timeStanmp) {
		super();
		this.msg =msg;
		this.errorCode = errorCode;
		this.timeStanmp = timeStanmp;
	}
	public String getErrorMessage() {
		return msg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public LocalDateTime getTimeStanmp() {
		return timeStanmp;
	}
	
}
