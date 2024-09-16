package com.ust.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public Product save(Product product) {
		return repository.save(product);
	}
	
	public String deleteProduct(long productId) {
		if(repository.existsById(productId)) {
			repository.deleteById(productId);
			return "Deleted Successfully";
		}else {
			return "No such product";
		}
	}
	
	public Product updateProduct(long productId,Product newProduct) {
		if(repository.existsById(productId)) {
			Product product = repository.findById(productId).get();
			product.setDescription(newProduct.getDescription());
			product.setPrice(newProduct.getPrice());
			return repository.save(product);
		}else {
			return null;
		}
	}
	
	public Product getProduct(long productId){
		Optional<Product> product = repository.findById(productId);
		return product.orElseThrow();
	}
	
	public List<Product> getProducts() {
		List<Product> products = repository.findAll();
		return products;
	}
}
