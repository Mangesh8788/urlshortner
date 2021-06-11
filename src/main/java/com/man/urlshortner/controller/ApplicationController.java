package com.man.urlshortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.man.urlshortner.service.UrlDetailService;

@RestController
public class ApplicationController {

	@Autowired
	private UrlDetailService urlDetailService;

	@GetMapping("/")
	public String checkHealthOfApp() {
		return "Health Ok!!";
	}

	@GetMapping("/{shortCode}")
	public RedirectView checkHealthOfApp(
			@PathVariable(name = "shortCode") String shortCode) {
		return urlDetailService.redirectShortUrlToActualUrl(shortCode);
	}

}
