package com.example.btvn4.service;

import com.example.btvn4.dto.CreateCategoryRequest;
import com.example.btvn4.dto.UpdateCategoryRequest;
import com.example.btvn4.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category addCategory(CreateCategoryRequest categoryRequest);
    public void removeCategory(Long id);
    public List<Category> findAll();
    public Category findById(Long id);
    public Category updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest);
}
