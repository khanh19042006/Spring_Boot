package com.example.btvn4.service;

import com.example.btvn4.dto.CreateProductRequest;
import com.example.btvn4.dto.UpdateProductRequest;
import com.example.btvn4.entity.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(CreateProductRequest productRequest);
    public Product updateProduct(UpdateProductRequest productRequest);
    public void removeProduct(Long id);
    public List<Product> findByName(String name);
    public List<Product> findByPriceBetween(Double min, Double max);
    public List<Product> findAll();
    public Product findById(Long id);
    public List<Product> findByCategoryId(Long categoryId);
}
