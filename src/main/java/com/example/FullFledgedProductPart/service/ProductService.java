package com.example.FullFledgedProductPart.service;

import com.example.FullFledgedProductPart.entities.Product;
import com.example.FullFledgedProductPart.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> getAll();

    ResponseEntity<Product> getById(Long productId);

    ResponseEntity<Product> updated(Long id, Product product);

    List<Product> findProductsByUserId(Long userId);

}
