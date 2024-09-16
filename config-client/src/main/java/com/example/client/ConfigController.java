package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/readprops")
public class ConfigController {

	@Value("${server.port.key}")
	String serverPort;
	
	@Value("${spring.application.name}")
	String appName;

	@Value("${spring.datasource.username}")
	String mysqlUsername;

	@Value("${spring.datasource.password}")
	String mysqlPassword;
			
	@GetMapping
	public String showProps() {
		String str1 = "port = "+ serverPort +" AppName= "+ appName;
		String str2 =  " mysqlUser: " + mysqlUsername + " mysqlPassword : "+mysqlPassword;
		return str1+str2;
	}
}
