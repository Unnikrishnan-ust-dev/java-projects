package com.example.sleuth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sleuth")
public class SleuthController {
	public static final Logger logger = LoggerFactory.getLogger(SleuthController.class);
	
	@GetMapping
	public String getMessage() {
		logger.info("info from sleuth");
		return "hello";
	}
}
