package com.man.urlshortner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.man.urlshortner.constant.UrlStatusConstant;
import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.helper.ApplicationProperties;
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
	@Autowired
	private ApplicationProperties applicationProperties;

	@Override
	public UrlDetailDto create(UrlDetailDto obj) {
		UrlDetail urlDetail = null;

		// Common data validation
		urlDetailServiceHelper.urlCommonDataValidator(obj);

		// Url Validator
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
				.findByShortCodeForUrlAndUrlStatus(shortCode,
						UrlStatusConstant.ACTIVE);
		// Validate the url
		urlDetailServiceHelper.urlRedirectionValidatior(urlDetail);
		return new RedirectView(urlDetail.getActualUrl());
	}

	@Override
	public List<UrlDetail> getAllActiveUrlDetails() {

		List<UrlDetail> urlDetailList = urlDetailRepository
				.findAllByUrlStatus(UrlStatusConstant.ACTIVE);
		urlDetailList.forEach(
				e -> e.setShortUrl(applicationProperties.getBaseUrlForShortUrl()
						+ e.getShortCodeForUrl()));
		return urlDetailList;
	}

}
