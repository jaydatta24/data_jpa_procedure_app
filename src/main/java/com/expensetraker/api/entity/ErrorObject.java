package com.expensetraker.api.entity;

import java.util.Date;

public class ErrorObject {

	private Integer statuscode;
	private String message;
	private Date timestamp;

	public ErrorObject(Integer statuscode, String message, Date timestamp) {
		super();
		this.statuscode = statuscode;
		this.message = message;
		this.timestamp = timestamp;
	}

	public ErrorObject() {
		super();
		
	}

	public Integer getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorObject [statuscode=" + statuscode + ", message=" + message + ", timestamp=" + timestamp + "]";
	}

}
