package com.example.feign_product_service.service;

import java.util.List;

import com.example.feign_product_service.resource.Product;

public interface ProductService {
	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);
}
