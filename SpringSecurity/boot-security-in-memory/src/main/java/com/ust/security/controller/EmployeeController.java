package com.ust.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

	@GetMapping("/")
	public String greet() {
		return "Hello Im Working";
	}
	
	@GetMapping("/admin")
	public String greetAdmin() {
		return "admin@Working";
	} 
	
	@GetMapping("/user")
	public String greetUser() {
		return "user@Working";
	}
}
