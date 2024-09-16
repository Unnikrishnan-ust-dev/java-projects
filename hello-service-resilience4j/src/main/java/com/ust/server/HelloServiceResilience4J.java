package com.ust.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloServiceResilience4J {

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceResilience4J.class, args);
	}
	
	@Bean
	public RestTemplate makeTemplate() {
		return new RestTemplate();
	}

}
