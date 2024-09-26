package com.ust.rest.service;


import java.util.List;
import com.ust.rest.model.Product;

public interface ProductService {
    public List<Product> getProducts();
    public Product getProduct(long id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(long id);
    public List<Product> getProductsByCategory(String category);
}
