package com.example.hexagonal.infrastructure.persistence.inmemory.product;

import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("memory")
public class ProductInMemoryConfig {

    @Bean
    public ProductRepositoryPort productRepositoryPort() {
        return new ProductInmemoryAdapter();
    }

}
