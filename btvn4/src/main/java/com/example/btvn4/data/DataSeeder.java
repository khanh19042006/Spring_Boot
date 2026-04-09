package com.example.btvn4.data;

import com.example.btvn4.entity.Category;
import com.example.btvn4.entity.Product;
import com.example.btvn4.repository.CategoryReponsitory;
import com.example.btvn4.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
    private final CategoryReponsitory categoryReponsitory;
    private final ProductRepository productRepository;

    private DataSeeder(CategoryReponsitory categoryReponsitory,
                       ProductRepository productRepository){
        this.categoryReponsitory = categoryReponsitory;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args){
        List<Category> categories = ListData.categories;
        List<Product> products = ListData.products;

        categoryReponsitory.saveAll(categories);
        productRepository.saveAll(products);
    }
}
