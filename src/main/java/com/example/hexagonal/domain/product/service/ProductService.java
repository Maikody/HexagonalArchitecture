package com.example.hexagonal.domain.product.service;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositoryPort productRepositoryPort;
    private final EmailNotificationPort emailNotificationPort;

    public List<Product> getProducts() {
        return productRepositoryPort.findAll();
    }

    public Product addProduct(Product product) {
        emailNotificationPort.send(Collections.singletonList("admin@admin.com"), "Product added");
        return productRepositoryPort.save(product);
    }
}
