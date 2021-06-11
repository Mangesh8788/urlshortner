package com.man.urlshortner.exception;

public class ErrorResponse {

	private int erroreCode;
	private String message;
	private String onField;

	public ErrorResponse(int erroreCode, String message, String onField) {
		super();
		this.erroreCode = erroreCode;
		this.message = message;
		this.onField = onField;
	}
	public int getErroreCode() {
		return erroreCode;
	}
	public void setErroreCode(int erroreCode) {
		this.erroreCode = erroreCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOnField() {
		return onField;
	}
	public void setOnField(String onField) {
		this.onField = onField;
	}

}
