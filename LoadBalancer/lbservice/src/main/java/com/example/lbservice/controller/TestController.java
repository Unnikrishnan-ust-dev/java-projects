package com.example.lbservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	Environment environment;
	
	@GetMapping("/hello")
	public String message() {
		return "Hello world. port="+environment.getProperty("local.server.port");
	}
}
