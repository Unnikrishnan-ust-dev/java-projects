package com.ust.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class HelloClientResource {
	@Autowired
	RestTemplate template;
	
	public final static String CLIENT_SERVICE="clientservice";

	@GetMapping("/")
	@CircuitBreaker(name = CLIENT_SERVICE,fallbackMethod = "callOnFail")
	public ResponseEntity<String> getMessage() {
		String url = "http://localhost:8071/rest/service/message";
		
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		
		return response;
	}
	
	@CircuitBreaker(name = CLIENT_SERVICE,fallbackMethod = "callOnFail")
	@GetMapping("/factorial/{number}")
	public ResponseEntity<String> getFact(@PathVariable int number) {
		String url = "http://localhost:8071/rest/service/factorial/"+number;
		
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		
		return response;
	}
	
	public ResponseEntity<String> callOnFail(Exception e) {
		return ResponseEntity.ok("Message from callOnFail()...");
	}
	
}
