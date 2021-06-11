package com.man.urlshortner.utility;

import com.man.urlshortner.dto.ResponseEntity;
import com.man.urlshortner.exception.CustomException;

public class RestResponseConverterUtil {

	public static <T> ResponseEntity<T> error(CustomException e) {
		return new ResponseEntity<>(e.getStatus(), e.getError(), false);
	}

	public static <T> ResponseEntity<T> error(Exception e) {
		return new ResponseEntity<>(500, e.getMessage());		
	}

	public static <T> ResponseEntity<T> success(T obj) {
		return new ResponseEntity<>(obj);
	}

}
