package com.example.lbeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LbeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LbeurekaApplication.class, args);
	}

}
