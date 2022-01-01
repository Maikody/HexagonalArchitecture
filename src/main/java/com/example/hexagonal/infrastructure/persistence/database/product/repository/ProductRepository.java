package com.example.hexagonal.infrastructure.persistence.database.product.repository;

import com.example.hexagonal.infrastructure.persistence.database.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
