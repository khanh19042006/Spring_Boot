package com.example.btvn4.service.Impl;

import com.example.btvn4.dto.CreateProductRequest;
import com.example.btvn4.dto.UpdateProductRequest;
import com.example.btvn4.entity.Product;
import com.example.btvn4.exception.DuplicateResourceException;
import com.example.btvn4.exception.ResourceNotFoundException;
import com.example.btvn4.repository.ProductRepository;
import com.example.btvn4.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(CreateProductRequest productRequest){
        Optional<Product> productCheck = productRepository.findByName(productRequest.getName());
        if (!productCheck.isEmpty())
            throw new DuplicateResourceException("Product", "name", productRequest.getName());

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setDescription(productRequest.getDescription());

        Product saved = productRepository.save(product);
        return saved;
    }

    @Override
    public Product updateProduct(UpdateProductRequest productRequest){
        Optional<Product> productCheck = productRepository.findByName(productRequest.getName());
        if (productCheck.isEmpty())
            throw new ResourceNotFoundException("Product", "name", productRequest.getName());

        Product product = productCheck.get();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setDescription(productRequest.getDescription());
        product.setActive(product.getActive());

        Product saved = productRepository.save(product);
        return saved;
    }

    @Override
    public void removeProduct(Long id){
        Optional<Product> productBox = productRepository.findById(id);
        if (productBox.isEmpty())
            throw new ResourceNotFoundException("Product", "id", id);

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name){
        List<Product> products = productRepository.findByNameContaining(name);
        return products;
    }

    @Override
    public List<Product> findByPriceBetween(Double min, Double max){
        List<Product> products = productRepository.findByPriceBetween(min, max);
        return products;
    }

    @Override
    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product findById(Long id){
        Optional<Product> productBox = productRepository.findById(id);
        if (productBox.isEmpty())
            throw new ResourceNotFoundException("Product", "id", id);

        return productBox.get();
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId){
        List<Product> products = productRepository.findByCategory_Id(categoryId);
        return products;
    }
}
