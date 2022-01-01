package com.example.hexagonal.domain.product.service;

import com.example.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.out.ProductRepositoryPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private static final Long EMPTY_ID = null;

    @InjectMocks
    private ProductService productService;
    @Mock
    private EmailNotificationPort emailNotificationPort;
    @Mock
    private ProductRepositoryPort productRepositoryPort;

    @Test
    void shouldAddProduct(){
        Product product = new Product(EMPTY_ID, "Product 1", "Description 1");
        when(productRepositoryPort.save(any())).then(invocationOnMock -> {
            product.setId(1L);
            return product;
        });

        Product result = productService.addProduct(product);

        Assertions.assertThat(result.getId()).isEqualTo(1L);
        Assertions.assertThat(result.getName()).isEqualTo("Product 1");
        Assertions.assertThat(result.getDescription()).isEqualTo("Description 1");
    }

}