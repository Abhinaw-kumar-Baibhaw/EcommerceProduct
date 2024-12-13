package com.example.FullFledgedProductPart.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String price;

    private String description;

    private Long userId;

    @Transient
    private List<ProductInventory> inventories = new ArrayList<>();

    Product(){

    }

    public Product(Long id, String name, String price, String description, Long userId, List<ProductInventory> inventories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.userId = userId;
        this.inventories = inventories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ProductInventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<ProductInventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
