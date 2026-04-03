package com.example.demo.service;

import com.example.demo.ProductStore;
import com.example.demo.dto.request.CreateProductRequest;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    // 1. Lấy product theo id
    public Product getProductById(String id){
        for (Product p : ProductStore.products){
            if (p.getId().equalsIgnoreCase(id))
                return p;
        }
        return null;
    }

    // 2. Lấy list product theo name
    public List<Product> getProductsByName(String name){
        List<Product> result = new ArrayList<>();

        for (Product p : ProductStore.products){
            if (p.getName().equalsIgnoreCase(name)){
                result.add(p);
            }
        }

        return result;
    }

    // 3. Lấy toàn bộ list
    public List<Product> getAllProducts(){
        return ProductStore.products;
    }

    // 4. Thêm product
    public CreateProductRequest create(CreateProductRequest createProductRequest){
        return createProductRequest;
    }

    // 5. Xóa product theo id
    public Product delete(String id){
        for (Product p : ProductStore.products){
            if (p.getId().equalsIgnoreCase(id)){
                ProductStore.products.remove(p);
                return p;
            }
        }
        return null;
    }
}