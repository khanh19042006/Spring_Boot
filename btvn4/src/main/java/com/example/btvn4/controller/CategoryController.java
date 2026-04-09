package com.example.btvn4.controller;

import com.example.btvn4.dto.CreateCategoryRequest;
import com.example.btvn4.dto.UpdateCategoryRequest;
import com.example.btvn4.dto.UpdateProductRequest;
import com.example.btvn4.dto.response.ApiResponse;
import com.example.btvn4.entity.Category;
import com.example.btvn4.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("{/api/categories}")
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    private CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> findAll(){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(categories));
    }

    @GetMapping("{/id}")
    public ResponseEntity<ApiResponse<Category>> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(category));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> addCategory(
            @RequestBody @Valid CreateCategoryRequest categoryRequest
    ){
        Category saved = categoryService.addCategory(categoryRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(saved));
    }

    @PutMapping("{/id}")
    public ResponseEntity<ApiResponse<Category>> updateCategory(
            @RequestBody @Valid UpdateCategoryRequest updateCategoryRequest,
            @PathVariable Long id
    ){
        Category category = categoryService.updateCategory(id, updateCategoryRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(category));
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces());
    }
}
