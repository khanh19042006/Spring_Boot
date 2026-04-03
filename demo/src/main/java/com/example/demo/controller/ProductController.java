package com.example.demo.controller;

import com.example.demo.dto.request.CreateProductRequest;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getListProduct(@RequestParam(name = "name") String name){
        if (name.equalsIgnoreCase("")){
            return productService.getAllProducts();
        }
        return productService.getProductsByName(name);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody CreateProductRequest createProduct){
        CreateProductRequest product = productService.create(createProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable String id){
        Product saved = productService.getProductById(id);
        if (saved != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable String id){
        Product delete = productService.delete(id);
        if (delete != null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
