package com.ust.rest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Product;
import com.ust.rest.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable long productId){
		Product product = service.getProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable long productId){
		Product newProduct = service.updateProduct(productId,product);
		return ResponseEntity.status(HttpStatus.OK).body(newProduct);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteProduct(productId));
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> product = service.getProducts();
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	@PostMapping(path="/createProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = service.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	}
}
