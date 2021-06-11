package com.man.urlshortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.man.urlshortner.constant.EndPointConstants;
import com.man.urlshortner.dto.ResponseEntity;
import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.service.UrlDetailService;
import com.man.urlshortner.utility.RestResponseConverterUtil;

@RestController
@RequestMapping(EndPointConstants.URL_SHORTNER)
public class UrlShortnerController {

	@Autowired
	private UrlDetailService urlDetailService;

	@PostMapping
	public ResponseEntity<String> createShortUrl(
			@RequestBody UrlDetailDto url) {
		return RestResponseConverterUtil.success(urlDetailService.create(url));
	}

}
