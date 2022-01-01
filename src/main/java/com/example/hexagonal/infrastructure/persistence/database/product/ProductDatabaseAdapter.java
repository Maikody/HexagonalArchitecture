package com.example.hexagonal.infrastructure.persistence.database.product;

import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import com.example.hexagonal.infrastructure.persistence.database.product.entity.ProductEntity;
import com.example.hexagonal.infrastructure.persistence.database.product.repository.ProductRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductDatabaseAdapter implements ProductRepositoryPort {

    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(x -> new Product(x.getId(), x.getName(), x.getDescription())).collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productRepository.save(new ProductEntity(product.getId(), product.getName(), product.getDescription()));

        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription());
    }
}
