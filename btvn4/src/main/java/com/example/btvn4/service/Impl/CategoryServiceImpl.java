package com.example.btvn4.service.Impl;

import com.example.btvn4.dto.CreateCategoryRequest;
import com.example.btvn4.dto.UpdateCategoryRequest;
import com.example.btvn4.entity.Category;
import com.example.btvn4.entity.Product;
import com.example.btvn4.exception.BadRequestException;
import com.example.btvn4.exception.DuplicateResourceException;
import com.example.btvn4.exception.ResourceNotFoundException;
import com.example.btvn4.repository.CategoryReponsitory;
import com.example.btvn4.repository.ProductRepository;
import com.example.btvn4.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryReponsitory categoryReponsitory;
    private final ProductRepository productRepository;

    private CategoryServiceImpl(CategoryReponsitory categoryReponsitory,
                                ProductRepository productRepository){
        this.categoryReponsitory = categoryReponsitory;
        this.productRepository = productRepository;
    }

    @Override
    public Category addCategory(CreateCategoryRequest categoryRequest){
        Optional<Category> categoryBox = categoryReponsitory.findByName(categoryRequest.getName());
        if (categoryBox.isPresent())
            throw new DuplicateResourceException("Category", "name", categoryRequest.getName());

        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        Category saved = categoryReponsitory.save(category);
        return saved;
    }

    @Override
    public void removeCategory(Long id){
        List<Product> products = productRepository.findByCategory_Id(id);
        for (Product p : products){
            if (p.getCategory().getId().equals(id))
                throw new BadRequestException("Không thể xóa Category đang chứa Product");
        }

        Optional<Category> categoryBox = categoryReponsitory.findById(id);
        if (categoryBox.isEmpty())
            throw new ResourceNotFoundException("Category", "id", id);

        categoryReponsitory.deleteById(id);
        return;
    }

    @Override
    public List<Category> findAll(){
        return categoryReponsitory.findAll();
    }

    @Override
    public Category findById(Long id){
        Optional<Category> categoryBox = categoryReponsitory.findById(id);
        if (categoryBox.isEmpty())
            throw new ResourceNotFoundException("Category", "id", id);

        return categoryBox.get();
    }

    @Override
    public Category updateCategory(Long id, UpdateCategoryRequest updateCategoryRequest){
        Optional<Category> categoryBox = categoryReponsitory.findById(id);
        if (categoryBox.isEmpty())
            throw new ResourceNotFoundException("Category", "id", id);

        Category category = categoryBox.get();
        category.setDescription(updateCategoryRequest.getDescription());
        category.setName(updateCategoryRequest.getName());

        Category saved = categoryReponsitory.save(category);
        return saved;
    }
}
