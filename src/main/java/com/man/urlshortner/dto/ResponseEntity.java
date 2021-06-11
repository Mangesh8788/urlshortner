package com.man.urlshortner.dto;

import com.man.urlshortner.exception.ErrorResponse;

public class ResponseEntity<T> {

	private int statusCode;
	private T result;
	private boolean validate;
	private ErrorResponse error;
	private String message;

	public ResponseEntity(int statusCode, T response, boolean validate) {
		this.statusCode = statusCode;
		this.result = response;
		this.validate = true;
	}

	public ResponseEntity(int statusCode, ErrorResponse error,
			boolean validate) {
		this.statusCode = statusCode;
		this.setError(error);
		this.validate = false;
	}

	public ResponseEntity(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
		this.validate = false;
	}

	public ResponseEntity(T response) {
		this(200, response, true);
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
