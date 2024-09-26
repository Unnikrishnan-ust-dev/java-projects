package com.ust.rest.controller;

import com.ust.rest.model.Product;
import com.ust.rest.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-api")
public class ProductController {
    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
        Product product = service.getProduct(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    @PreAuthorize(value= "hasRole('ADMIN')")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products-by-category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = service.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = service.addProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product newProduct = service.updateProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        Product product = service.deleteProduct(id);
        return ResponseEntity.ok(product);
    }
}
