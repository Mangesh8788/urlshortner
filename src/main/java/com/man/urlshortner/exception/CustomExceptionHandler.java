package com.man.urlshortner.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.man.urlshortner.utility.RestResponseConverterUtil;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public Object handleCustomException(CustomException e,
			HttpServletResponse response) {
		response.setStatus(e.getStatus());
		return RestResponseConverterUtil.error(e);
	}

	@ExceptionHandler(Exception.class)
	public Object handleException(Exception e, HttpServletResponse response) {
		response.setStatus(500);
		return RestResponseConverterUtil.error(e);
	}

}
