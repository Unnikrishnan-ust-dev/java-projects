package com.ust.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.ws.rs.core.HttpHeaders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/rest/service")
public class HelloController {
	
	@Autowired
	RestTemplate template;

	@GetMapping("/message")
	public String hello() {
		return "hello user";
	}
	
	@GetMapping("/factorial/{number}")
	public String getFactorial(@PathVariable int number) {
		int fact = 1;
		for(int i=1;i<=number;i++) {
			fact *= i;
		}
		return "The factorial of " + number + " is " + fact;
	}
	
	@GetMapping("/square/{number}")
	public String getSquare(@PathVariable int number) {
		int square = number * number;
		return "The sqaure of " + number + " is " + square;
	}
	
	@GetMapping("/random")
	public ResponseEntity<String> getRandom() {
		String url = "https://bored-api.appbrewery.com/random";
		ResponseEntity<String> response = template.getForEntity(url, null);
		return response;
	}
}
