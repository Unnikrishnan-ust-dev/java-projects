package com.ust.security.service;

import java.util.List;

import com.ust.security.model.Product;


public interface ProductService {
	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);
}
