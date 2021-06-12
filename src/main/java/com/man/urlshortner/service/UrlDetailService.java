package com.man.urlshortner.service;

import java.util.List;

import org.springframework.web.servlet.view.RedirectView;

import com.man.urlshortner.dto.UrlDetailDto;
import com.man.urlshortner.model.UrlDetail;

public interface UrlDetailService extends CrudService<UrlDetailDto> {

	public RedirectView redirectShortUrlToActualUrl(String shortCode);

	public List<UrlDetail> getAllActiveUrlDetails();
}
