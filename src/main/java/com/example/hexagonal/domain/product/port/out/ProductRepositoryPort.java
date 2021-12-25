package com.example.hexagonal.domain.product.port.out;

import com.example.hexagonal.domain.product.model.Product;

import java.util.List;

public interface ProductRepositoryPort {
    List<Product> findAll();

    Product save(Product product);
}
