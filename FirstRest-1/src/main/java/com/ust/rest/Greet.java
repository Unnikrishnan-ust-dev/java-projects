package com.ust.rest;

import java.net.http.HttpHeaders;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api1.0")
public class Greet {
	
	@GetMapping("/message")
	public String greet() {
		return "hello world";	
	}
	
	@GetMapping("/time")
	public String getTime() {
		return Calendar.getInstance().getTime().toString();
	}
	
	@GetMapping("/gender/{gender}/{name}")
	public String getGender(@RequestHeader HttpHeaders headers, @PathVariable String gender,@PathVariable String name) {
		
		Set<String> set = headers.keySet();
		Iterator<String> keys = set.iterator();
		
		String keyStr = null;
		while(keys.hasNext()) {
			keyStr += keys.next() + "\n";
		}
		
		String keyValueStr = null;
		Set<Entry<String,List<String>>> entries = headers.entrySet();
		Iterator iter2 = entries.iterator();
		while(iter2.hasNext()) {
			keyValueStr += iter2.next()+ "<br/>";
		}
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.setContentType(MediaType.TEXT_HTML();
		headers2.set("ust"."Gamma TRaining");
//		if(gender.equals("male") ) {
//			return "Welcome Mr. "+name;
//		}else if(gender.equals("female")) {
//			return "Welcome Ms. "+name;
//		}else {
//			return "Welcome "+name;
//		}
		
		return ResponseEntity.status(HttpStatus.OK).header(headers2, null).body(keyValueStr);
		
	}
	
	@PostMapping("/getPerson")
	public ResponseEntity<String> getPerson(@RequestBody Person person){
		
		return ResponseEntity.status(HttpStatus.OK).body(person.getName()+person.getAge());
	}
	
	
	
	
}
