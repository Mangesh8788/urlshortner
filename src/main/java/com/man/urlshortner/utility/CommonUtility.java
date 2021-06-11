package com.man.urlshortner.utility;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public interface CommonUtility {

	public Predicate<String> IS_STRING_EMPTY_OR_NULL = e -> StringUtils
			.isEmpty(e);
}
