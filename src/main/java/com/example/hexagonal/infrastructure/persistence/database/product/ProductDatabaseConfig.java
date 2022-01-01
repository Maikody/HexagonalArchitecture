package com.example.hexagonal.infrastructure.persistence.database.product;

import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import com.example.hexagonal.infrastructure.persistence.database.product.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!memory")
public class ProductDatabaseConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort(ProductRepository productRepository) {
        return new ProductDatabaseAdapter(productRepository);
    }
}
