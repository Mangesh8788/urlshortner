package com.man.urlshortner.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlDetailDto {

	private int id;
	private String url;
	private String shortCode;
	private String shortUrl;
	private Date expiryDate;
}
