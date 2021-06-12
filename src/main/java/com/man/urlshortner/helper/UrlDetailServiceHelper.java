package com.man.urlshortner.helper;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.man.urlshortner.constant.UrlStatusConstant;
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
		urlDetail.setUrlStatus(UrlStatusConstant.ACTIVE);
		urlDetail.setUrlExpiryDate(obj.getExpiryDate());
		commonHelper.setCreate(urlDetail, "SYSTEM");
		return urlDetailRepo.save(urlDetail);
	}

	public void urlRedirectionValidatior(UrlDetail urlDetail) {
		if (urlDetail == null) {
			commonHelper.prepareAndThrowException(HttpStatus.NOT_FOUND.value(),
					"Not found!", "Url");
		}
	}

	public void urlCommonDataValidator(UrlDetailDto obj) {
		if (obj.getExpiryDate() != null) {
			if (obj.getExpiryDate().toLocalDate().isBefore(LocalDate.now())) {
				commonHelper.prepareAndThrowException(
						HttpStatus.NOT_ACCEPTABLE.value(),
						"Expiry date value cant be less than current date!",
						"expiry_date");
			}
		}
	}

	/*
	 * Changes the status of url having expiry date less than current date.
	 */
	public void run() {
		urlDetailRepo.updateUrlStatus(UrlStatusConstant.EXPIRED.toString());
	}

}
