package com.example.btvn4.data;

import com.example.btvn4.entity.Category;
import com.example.btvn4.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public class ListData {
    public static List<Category> categories = List.of(
            new Category(1L, "Điện thoại", "Danh mục các sản phẩm điện thoại thông minh", LocalDateTime.now(), LocalDateTime.now(), null),
            new Category(2L, "Laptop", "Danh mục laptop văn phòng và gaming", LocalDateTime.now(), LocalDateTime.now(), null),
            new Category(3L, "Phụ kiện", "Danh mục phụ kiện công nghệ", LocalDateTime.now(), LocalDateTime.now(), null)
    );

    public static List<Product> products = List.of(
            new Product(1L, "iPhone 15 Pro", 28990000.0, 10, "Điện thoại flagship Apple", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(0)),
            new Product(2L, "Samsung Galaxy S24", 23990000.0, 8, "Điện thoại Samsung cao cấp", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(0)),
            new Product(3L, "Xiaomi 14", 17990000.0, 12, "Điện thoại cấu hình mạnh giá tốt", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(0)),
            new Product(4L, "MacBook Air M3", 31990000.0, 5, "Laptop mỏng nhẹ chip M3", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(1)),
            new Product(5L, "Dell XPS 13", 27990000.0, 4, "Laptop văn phòng cao cấp", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(1)),
            new Product(6L, "Asus ROG Strix", 35990000.0, 3, "Laptop gaming hiệu năng cao", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(1)),
            new Product(7L, "Tai nghe Sony WH-1000XM5", 7990000.0, 15, "Tai nghe chống ồn cao cấp", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(2)),
            new Product(8L, "Chuột Logitech MX Master 3S", 2490000.0, 20, "Chuột không dây cao cấp", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(2)),
            new Product(9L, "Bàn phím Keychron K8", 2190000.0, 18, "Bàn phím cơ không dây", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(2)),
            new Product(10L, "Sạc nhanh Anker 65W", 990000.0, 30, "Sạc nhanh đa cổng cho laptop và điện thoại", true, LocalDateTime.now(), LocalDateTime.now(), categories.get(2))
    );
}
