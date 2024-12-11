package com.example.FullFledgedProductPart.controller;

import com.example.FullFledgedProductPart.entities.Product;
import com.example.FullFledgedProductPart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
        return productService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
      return productService.getById(id);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Product> updated(@PathVariable Long id,@RequestBody Product product){
        return productService.updated(id,product);
    }

    @GetMapping("/getUserProducts/{id}")
    public List<Product> getUserProduct(@PathVariable("id") Long userId){
      return productService.findProductsByUserId(userId);
    }

}
