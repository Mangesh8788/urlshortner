package com.man.urlshortner.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.man.urlshortner.constant.ApiErrorMessageConstants;
import com.man.urlshortner.model.UrlDetail;
import com.man.urlshortner.repository.UrlDetailRepository;
import com.man.urlshortner.utility.CommonUtility;

@Component
public class UrlShortCodeAndUrlValidatorHelper {

	@Autowired
	private UrlDetailRepository urlDetailRepo;
	@Autowired
	private CommonHelper commonHelper;

	/*
	 * Url validated here.
	 */
	public String validateInputUrl(String url) {

		if (!CommonUtility.IS_STRING_EMPTY_OR_NULL.test(url)) {
			if (!url.contains("//") && !url.startsWith("http://")
					&& (!url.startsWith("https://"))) {
				url = "http://" + url;
			}
			UrlValidator urlValidator = new UrlValidator();
			if (!urlValidator.isValid(url)) {
				commonHelper.prepareAndThrowException(
						HttpStatus.UNPROCESSABLE_ENTITY.value(),
						ApiErrorMessageConstants.INVALID_URL,
						UrlDetail.ACTUAL_URL);
			}
		} else {
			commonHelper.prepareAndThrowException(
					HttpStatus.UNPROCESSABLE_ENTITY.value(),
					ApiErrorMessageConstants.URL_EMPTY_NULL,
					UrlDetail.ACTUAL_URL);
		}

		return url;
	}

	// Unique Code is generated here.
	public String generateUniqueCode(String url) {
		boolean isShortCodeAlreadyExist = true;
		String shortCode = null;
		while (isShortCodeAlreadyExist) {
			shortCode = RandomStringUtils.random(6, true, true);
			if (urlDetailRepo.findByShortCodeForUrl(shortCode) == null) {
				break;
			}
		}

		return shortCode;
	}

}
