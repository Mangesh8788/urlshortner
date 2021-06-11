package com.man.urlshortner.service;

import org.springframework.web.servlet.view.RedirectView;

import com.man.urlshortner.dto.UrlDetailDto;

public interface UrlDetailService extends CrudService<UrlDetailDto> {

	public RedirectView redirectShortUrlToActualUrl(String shortCode);
}
