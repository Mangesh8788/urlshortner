package com.man.urlshortner.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.model.UrlDetail;
import com.man.urlshortner.repository.UrlDetailRepository;

@Component
public class UrlDetailServiceHelper {
	@Autowired
	private UrlDetailRepository urlDetailRepo;
	@Value("${base.url}")
	private String baseUrl;
	@Autowired
	private CommonHelper commonHelper;

	public UrlDetailDto convertEntityToDto(UrlDetail urlDetail,
			UrlDetailDto obj) {
		obj.setId(urlDetail.getId());
		obj.setShortUrl(baseUrl + obj.getShortCode());
		return obj;
	}

	public UrlDetail convertDtoToEntity(UrlDetail urlDetail, UrlDetailDto obj) {
		urlDetail = new UrlDetail();
		urlDetail.setActualUrl(obj.getUrl());
		urlDetail.setShortCodeForUrl(obj.getShortCode());
		return urlDetailRepo.save(urlDetail);
	}

	public void urlRedirectionValidatior(UrlDetail urlDetail) {
		if (urlDetail == null) {
			commonHelper.prepareAndThrowException(HttpStatus.NOT_FOUND.value(),
					"Not found!", "Url");
		}
	}
}
