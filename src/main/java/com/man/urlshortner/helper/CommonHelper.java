package com.man.urlshortner.helper;

import org.springframework.stereotype.Component;

import com.man.urlshortner.exception.CustomException;
import com.man.urlshortner.exception.ErrorResponse;

@Component
public class CommonHelper {

	public void prepareAndThrowException(int statusCode, String message,
			String onField) {
		throw new CustomException(statusCode, message,
				new ErrorResponse(statusCode, message, onField));
	}
}
