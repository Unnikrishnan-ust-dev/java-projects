package com.ust.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/rest/client")
public class ClientController {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/message")
	public ResponseEntity<String> connect() {
		String url = "http://localhost:8073/rest/service/message";
		
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		return response;
	}
	
	@GetMapping("/factorial/{number}")
	public ResponseEntity<String> factorial(@PathVariable int number) {
		String url = "http://localhost:8073/rest/service/factorial/"+number;
		
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		return response;
	}
	
	@GetMapping("/square/{number}")
	public ResponseEntity<String> square(@PathVariable int number) {
		String url = "http://localhost:8073/rest/service/square/"+number;
		
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		return response;
	}
}
