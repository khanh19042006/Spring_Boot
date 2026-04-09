package com.example.btvn4.repository;

import com.example.btvn4.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryReponsitory extends JpaRepository<Category, Long> {
    public void deleteById(Long id);
    public Optional<Category> findByName(String name);
}
