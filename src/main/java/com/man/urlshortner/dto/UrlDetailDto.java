package com.man.urlshortner.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDetailDto {

	private int id;
	private String url;
	private String shortCode;
	private String shortUrl;
}
