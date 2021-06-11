package com.man.urlshortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.helper.UrlShortCodeAndUrlValidatorHelper;

@Service
public class UrlDetailServiceImpl implements UrlDetailService {

	@Autowired
	private UrlShortCodeAndUrlValidatorHelper urlShortCodeAndValidator;

	@Override
	public String create(UrlDetailDto obj) {
		// Url Validated
		urlShortCodeAndValidator.validateInputUrl(obj.getUrl());
		return obj.getUrl();
	}

	@Override
	public String update(UrlDetailDto obj, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlDetailDto get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
