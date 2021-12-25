package com.example.hexagonal.infrastructure.application.rest.product;

import com.example.hexagonal.domain.product.adapter.ProductServiceAdapter;
import com.example.hexagonal.domain.product.port.in.ProductServicePort;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import com.example.hexagonal.domain.product.service.ProductService;
import com.example.hexagonal.infrastructure.persistence.inmemory.product.ProductInmemoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductServicePort productServicePort() {
        return new ProductServiceAdapter(
                new ProductService(
                        productRepositoryPort()));
    }

    @Bean
    public ProductRepositoryPort productRepositoryPort() {
        return new ProductInmemoryAdapter();
    }
}
