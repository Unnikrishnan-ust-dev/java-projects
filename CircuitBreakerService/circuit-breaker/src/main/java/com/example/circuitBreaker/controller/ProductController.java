package com.example.circuitBreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/client")
public class ProductController {
	@Autowired
	RestTemplate template;
	
	@CircuitBreaker(name = "client-cb",fallbackMethod = "generateResponse")
	 @GetMapping("/allProducts")
	 public ResponseEntity<String> getAll() {
		String url = "http://localhost:7891/product-service/products";
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		return response;
	 }

	 																																												//http://localhost:7082/client/products-by-id/
//	 @GetMapping("/products-by-id/{id}")
//		public Product getProductById(@PathVariable ("id") int id) {
//		   return feignclient.getProductsById(id);
//	 }
//
//	 																																										// http://localhost:7082/client/products-by-category/Mobile
//	 @GetMapping("/products-by-category/{category}")
//		public List<Product> getProductsByCategory(@PathVariable("category") String category){
//		     return feignclient.getProductsByCategory(category);
//	 }
	 
	 public String generateResponse(Throwable throwable) {
		 return "The server is unavailable temporarily.Please try after some time";
	 }
}
