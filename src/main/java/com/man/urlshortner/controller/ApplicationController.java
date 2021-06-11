package com.man.urlshortner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@GetMapping("/")
	public String checkHealthOfApp() {
		return "Health Ok!!";
	}
}
