package com.example.hexagonal.domain.product.adapter;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import com.example.hexagonal.domain.product.service.ProductService;
import com.example.hexagonal.infrastructure.notification.inmemory.email.EmailNotificationAdapter;
import com.example.hexagonal.infrastructure.persistence.inmemory.product.ProductInmemoryAdapter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceAdapterTest {

    private static final Long EMPTY_ID = null;
    private ProductRepositoryPort productRepositoryPort = new ProductInmemoryAdapter();
    private EmailNotificationPort emailNotificationPort = new EmailNotificationAdapter();
    private ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(new ProductService(productRepositoryPort, emailNotificationPort));

    @Test
    void shouldAddProduct() {
        Product product = new Product(EMPTY_ID, "Product 1", "Description 1");

        Product result = productServiceAdapter.addProduct(product);

        assertThat(result.getId()).isNotNull();
    }

    @Test
    void shouldGetProducts() {
        productRepositoryPort.save(new Product(null, "Product 1", "Description 1"));

        List<Product> products = productServiceAdapter.getProducts();

        assertThat(products).isNotEmpty();
    }

}