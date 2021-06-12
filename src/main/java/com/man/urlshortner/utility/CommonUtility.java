package com.man.urlshortner.utility;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public interface CommonUtility {

	public Predicate<String> IS_STRING_EMPTY_OR_NULL = e -> StringUtils
			.isEmpty(e);

	public static Timestamp getCurrentTimeStamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}
}
