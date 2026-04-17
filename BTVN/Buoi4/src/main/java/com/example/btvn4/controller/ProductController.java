package com.example.btvn4.controller;

import com.example.btvn4.dto.CreateProductRequest;
import com.example.btvn4.dto.UpdateProductRequest;
import com.example.btvn4.dto.response.ApiResponse;
import com.example.btvn4.entity.Product;
import com.example.btvn4.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Validated
@Tag(name = "Product Management", description = "Api quản lý sản phẩm")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Lấy tất cả sản phẩm")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(products));
    }

    @Operation(summary = "Lấy sản phẩm theo id của sản phẩm")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(product));
    }

    @Operation(summary = "Thêm 1 sản phẩm vào database")
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(
            @RequestBody @Valid CreateProductRequest createProductRequest
    ){
        Product product = productService.addProduct(createProductRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @RequestBody @Valid UpdateProductRequest updateProductRequest,
            @PathVariable Long id
    ){
        Product product = productService.updateProduct(updateProductRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(
            @PathVariable Long id
    ){
        productService.removeProduct(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces());
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Product>>> findByName(
            @RequestParam String keyword
    ){
        List<Product> products = productService.findByName(keyword);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(products));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<ApiResponse<List<Product>>> findByCategoryId(
            @PathVariable Long categoryId
    ){
        List<Product> products = productService.findByCategoryId(categoryId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(products));
    }

    @GetMapping("/price")
    public ResponseEntity<ApiResponse<List<Product>>> findByPriceBetween(
            @RequestParam Double min,
            @RequestParam Double max
    ){
        List<Product> products = productService.findByPriceBetween(min, max);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.sussces(products));
    }
}
