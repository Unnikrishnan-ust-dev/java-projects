package com.ust.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locale")
public class Greet {
	
	@GetMapping("/{locale}")
	public String greet(@RequestHeader HttpHeaders headers,@PathVariable String locale) {
		HashMap<String, String> greetingsList = new HashMap<>();
		greetingsList.put("US", "Hi");
		greetingsList.put("UK", "Hello");
		greetingsList.put("IN", "नमस्ते");
		
		String localeValue = headers.get("locale").get(0);
		if(localeValue!=null && greetingsList.containsKey(localeValue)) {
			return greetingsList.get(localeValue);
		}else {
			return "Unrecognized locale. Welcome";
		}
	}
	
	@GetMapping("/getLocales")
	public String getLocales() {
		Locale[] availablelocale = Locale.getAvailableLocales();
		List<String> localeNames = new ArrayList<>();
		for(int i=0;i<availablelocale.length;i++) {
			localeNames.add("("+availablelocale[i].getCountry()+","+availablelocale[i].getDisplayLanguage()+")"+"\n");
		}
		return localeNames.toString();
	}
}
