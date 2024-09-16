package com.ust.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan
public class FirstRestJpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestJpaMysqlApplication.class, args);
	}

}
