package com.example.btvn4.repository;

import com.example.btvn4.dto.CreateProductRequest;
import com.example.btvn4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByNameContaining(String keyword);
    public List<Product> findByCategory_Id(Long categoryId);
    public List<Product> findByPriceBetween(Double min, Double max);
    public void deleteById(Long id);
    public Optional<Product> findByName(String name);
    public Optional<Product> findById(Long id);
}
