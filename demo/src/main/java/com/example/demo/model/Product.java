package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Product {
    @NotBlank
    private String id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Positive
    private Double price;

    @Size(max = 500)
    private String description;

    @NotBlank
    private String category;


    public Product() {
    }

    public Product(String id, String name, double price, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
