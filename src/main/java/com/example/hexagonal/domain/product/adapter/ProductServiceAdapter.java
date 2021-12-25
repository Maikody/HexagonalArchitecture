package com.example.hexagonal.domain.product.adapter;

import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.in.ProductServicePort;
import com.example.hexagonal.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceAdapter implements ProductServicePort {
    private final ProductService productService;

    @Override
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Override
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }
}
