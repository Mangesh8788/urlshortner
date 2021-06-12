package com.man.urlshortner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.man.urlshortner.constant.EndPointConstants;
import com.man.urlshortner.dto.ResponseEntity;
import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.model.UrlDetail;
import com.man.urlshortner.service.UrlDetailService;
import com.man.urlshortner.utility.RestResponseConverterUtil;

@RestController
@RequestMapping(EndPointConstants.URL_SHORTNER)
public class UrlShortnerController {

	@Autowired
	private UrlDetailService urlDetailService;

	@PostMapping
	public ResponseEntity<UrlDetailDto> createShortUrl(
			@RequestBody UrlDetailDto url) {
		return RestResponseConverterUtil.success(urlDetailService.create(url));
	}
	
	@GetMapping
	public ResponseEntity<List<UrlDetail>> getAllActiveUrlDetail(){
		return RestResponseConverterUtil.success(urlDetailService.getAllActiveUrlDetails());
	}

}
