package com.example.hexagonal.domain.product.adapter;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import com.example.hexagonal.domain.product.service.ProductService;
import com.example.hexagonal.infrastructure.persistence.inmemory.product.ProductInmemoryAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceAdapterMockTest {

    private static final Long EMPTY_ID = null;
    private ProductRepositoryPort productRepositoryPort = mock(ProductRepositoryPort.class);
    private EmailNotificationPort emailNotificationPort = mock(EmailNotificationPort.class);
    private ProductServiceAdapter productServiceAdapter = new ProductServiceAdapter(new ProductService(productRepositoryPort, emailNotificationPort));

    @Test
    void shouldAddProduct() {
        Product product = new Product(EMPTY_ID, "Product 1", "Description 1");
        when(productRepositoryPort.save(any())).then(invocationOnMock -> {
            product.setId(1L);
            return product;
        });
        Product result = productServiceAdapter.addProduct(product);

        assertThat(result.getId()).isNotNull();
    }

    @Test
    void shouldGetProducts() {
        when(productRepositoryPort.findAll()).thenAnswer(invocationOnMock ->
            Collections.singletonList(new Product(EMPTY_ID, "Product 1", "Description 1"))
        );
        productRepositoryPort.save(new Product(EMPTY_ID, "Product 1", "Description 1"));
        
        List<Product> products = productServiceAdapter.getProducts();

        assertThat(products).isNotEmpty();
    }

}