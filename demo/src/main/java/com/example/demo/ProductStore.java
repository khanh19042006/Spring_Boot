package com.example.demo;

import com.example.demo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductStore {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("1", "Laptop", 1200.0, "High performance laptop", "Electronics"));
        products.add(new Product("2", "Phone", 800.0, "Smartphone with OLED display", "Electronics"));
        products.add(new Product("3", "Tablet", 500.0, "Portable tablet device", "Electronics"));
    }
}