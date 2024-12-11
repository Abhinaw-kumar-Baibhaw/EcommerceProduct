package com.example.FullFledgedProductPart.repo;

import com.example.FullFledgedProductPart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findProductsByUserId(Long id);
}
