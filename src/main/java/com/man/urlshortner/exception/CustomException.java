package com.man.urlshortner.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int status;
	private String message;
	private ErrorResponse error;

	public CustomException(int status, String message, ErrorResponse error) {
		super(message);
		this.status = status;
		this.message = message;
		this.error = error;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
