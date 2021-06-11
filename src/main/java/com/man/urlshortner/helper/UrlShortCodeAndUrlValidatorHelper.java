package com.man.urlshortner.helper;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.man.urlshortner.constant.ApiErrorMessageConstants;
import com.man.urlshortner.exception.CustomException;
import com.man.urlshortner.exception.ErrorResponse;
import com.man.urlshortner.model.UrlDetail;
import com.man.urlshortner.utility.CommonUtility;

@Component
public class UrlShortCodeAndUrlValidatorHelper {

	/*
	 * Url validated here.
	 */
	public String validateInputUrl(String url) {

		if (!url.contains("//")
				&& !CommonUtility.IS_STRING_EMPTY_OR_NULL.test(url)) {
			if (!url.startsWith("http://") && (!url.startsWith("https://"))) {
				url = "http://" + url;
			}
			UrlValidator urlValidator = new UrlValidator();
			if (!urlValidator.isValid(url)) {
				prepareAndThrowException(
						HttpStatus.UNPROCESSABLE_ENTITY.value(),
						ApiErrorMessageConstants.INVALID_URL,
						UrlDetail.ACTUAL_URL);
			}
		} else {
			prepareAndThrowException(HttpStatus.UNPROCESSABLE_ENTITY.value(),
					ApiErrorMessageConstants.URL_EMPTY_NULL,
					UrlDetail.ACTUAL_URL);
		}

		return url;
	}

	public void prepareAndThrowException(int statusCode, String message,
			String onField) {
		throw new CustomException(statusCode, message,
				new ErrorResponse(statusCode, message, onField));
	}
}
