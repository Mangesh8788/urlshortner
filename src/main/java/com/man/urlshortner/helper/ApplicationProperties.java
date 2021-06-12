package com.man.urlshortner.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ApplicationProperties {

	@Value("${base.url}")
	private String baseUrlForShortUrl;
}
