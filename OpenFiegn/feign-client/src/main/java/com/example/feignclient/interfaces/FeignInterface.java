package com.example.feignclient.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.feignclient.model.Product;

@FeignClient(value="feignclient", url="http://localhost:7891/product-service")
public interface FeignInterface {

	@GetMapping("/products")
	public List<Product> getProducts();

    @GetMapping( value= "/products-by-id/{id}", produces="application/json")
	public Product getProductsById(@PathVariable ("id") int id);

	@GetMapping( value="/products-by-category/{category}", produces="application/json")
	public List<Product> getProductsByCategory(@PathVariable ("category") String category);


}
