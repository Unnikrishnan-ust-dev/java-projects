package com.ust.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloserverApplication.class, args);
	}
	
	@Bean
	public RestTemplate makeTemplate() {
		return new RestTemplate();
	}

}
