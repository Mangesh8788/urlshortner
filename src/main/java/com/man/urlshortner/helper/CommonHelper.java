package com.man.urlshortner.helper;

import org.springframework.stereotype.Component;

import com.man.urlshortner.exception.CustomException;
import com.man.urlshortner.exception.ErrorResponse;
import com.man.urlshortner.model.AuditableEntiy;
import com.man.urlshortner.utility.CommonUtility;

@Component
public class CommonHelper {

	public void prepareAndThrowException(int statusCode, String message,
			String onField) {
		throw new CustomException(statusCode, message,
				new ErrorResponse(statusCode, message, onField));
	}

	public void setCreate(AuditableEntiy audit, String createdBy) {
		audit.setCreatedBy(createdBy);
		audit.setCreatedDate(CommonUtility.getCurrentTimeStamp());
		audit.setUpdatedBy(createdBy);
		audit.setUpdatedDate(CommonUtility.getCurrentTimeStamp());
	}
}
