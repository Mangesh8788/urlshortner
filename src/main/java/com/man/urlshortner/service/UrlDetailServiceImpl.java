package com.man.urlshortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.helper.UrlDetailServiceHelper;
import com.man.urlshortner.helper.UrlShortCodeAndUrlValidatorHelper;
import com.man.urlshortner.model.UrlDetail;
import com.man.urlshortner.repository.UrlDetailRepository;

@Service
public class UrlDetailServiceImpl implements UrlDetailService {

	@Autowired
	private UrlShortCodeAndUrlValidatorHelper urlShortCodeAndValidator;
	@Autowired
	private UrlDetailServiceHelper urlDetailServiceHelper;
	@Autowired
	private UrlDetailRepository urlDetailRepository;

	@Override
	public UrlDetailDto create(UrlDetailDto obj) {
		UrlDetail urlDetail = null;

		// Url Validated and set
		obj.setUrl(urlShortCodeAndValidator.validateInputUrl(obj.getUrl()));

		// Generate Short Code
		obj.setShortCode(
				urlShortCodeAndValidator.generateUniqueCode(obj.getUrl()));

		// save data to db
		urlDetail = urlDetailServiceHelper.convertDtoToEntity(urlDetail, obj);

		// create response
		return urlDetailServiceHelper.convertEntityToDto(urlDetail, obj);

	}

	@Override
	public UrlDetailDto update(UrlDetailDto obj, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlDetailDto delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlDetailDto get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RedirectView redirectShortUrlToActualUrl(String shortCode) {
		UrlDetail urlDetail = urlDetailRepository
				.findByShortCodeForUrl(shortCode);
		// Validate the url
		urlDetailServiceHelper.urlRedirectionValidatior(urlDetail);
		return new RedirectView(urlDetail.getActualUrl());
	}

}
