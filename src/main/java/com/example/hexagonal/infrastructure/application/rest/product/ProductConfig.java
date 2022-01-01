package com.example.hexagonal.infrastructure.application.rest.product;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import com.example.hexagonal.domain.product.adapter.ProductServiceAdapter;
import com.example.hexagonal.domain.product.port.in.ProductServicePort;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import com.example.hexagonal.domain.product.service.ProductService;
import com.example.hexagonal.infrastructure.notification.inmemory.email.EmailNotificationAdapter;
import com.example.hexagonal.infrastructure.persistence.database.product.ProductDatabaseAdapter;
import com.example.hexagonal.infrastructure.persistence.database.product.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductServicePort productServicePort(ProductRepositoryPort productRepositoryPort, EmailNotificationPort emailNotificationPort) {
        return new ProductServiceAdapter(new ProductService(productRepositoryPort, emailNotificationPort));
    }

 }
