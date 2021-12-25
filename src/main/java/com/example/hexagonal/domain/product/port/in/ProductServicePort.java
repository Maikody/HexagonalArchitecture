package com.example.hexagonal.domain.product.port.in;

import com.example.hexagonal.domain.product.model.Product;

import java.util.List;

public interface ProductServicePort {
    List<Product> getProducts();

    Product addProduct(Product product);
}
