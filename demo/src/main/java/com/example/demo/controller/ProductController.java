package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @GetMapping
    public List<Product> getListProduct(@RequestParam(name = "name") String name){
        if (name.equalsIgnoreCase("")){
            return productService.findProductByName(name);
        }
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody createProductRequest createProduct){
        Product product = productService.create(createProduct);
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
    public boolean deleteProductById(@PathVariable String id){
        Product delete = productService.delete(id);
        if (delete != null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(delete);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(delete);
    }
}
