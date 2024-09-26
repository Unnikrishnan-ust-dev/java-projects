package com.ust.rest.service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        if(repository.existsById(id)) {
            return repository.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        if(repository.existsById(product.getProductId())){
            return repository.save(product);
        }else{
            return null;
        }
    }

    @Override
    public Product deleteProduct(long id) {
        if(repository.existsById(id)){
            Product product = repository.findById(id).get();
            repository.deleteById(id);
            return product;
        }else{
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return repository.getProductsByCategory(category);
    }
}
