package com.example.FullFledgedProductPart.serviceImplementation;

import com.example.FullFledgedProductPart.entities.Product;
import com.example.FullFledgedProductPart.entities.ProductInventory;
import com.example.FullFledgedProductPart.repo.ProductRepo;
import com.example.FullFledgedProductPart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;



@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product create(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public ResponseEntity<Product> getById(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        if (product.isPresent()) {
            Product product1 = product.get();
            try {
                String url = "http://FullFledgedInventoryPart/inventory/getById/" + product1.getId();
                ProductInventory productInventories = restTemplate.getForObject(url, ProductInventory.class);
                List<ProductInventory> customerOrders = Arrays.asList(productInventories);
                product1.setInventories(customerOrders);
                return ResponseEntity.ok(product1);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Product> updated(Long id, Product product) {
        Optional<Product> product1 = productRepo.findById(id);
        if(product1.isPresent()){
            Product product2 = product1.get();
            product2.setName(product.getName());
            product2.setDescription(product.getDescription());
            product2.setPrice(product.getPrice());
            return new ResponseEntity<>(productRepo.save(product2),HttpStatus.OK);
        }
        return new ResponseEntity<>(product,HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    public List<Product> findProductsByUserId(Long userId) {
        return productRepo.findProductsByUserId(userId);
    }
}
