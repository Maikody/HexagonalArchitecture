package com.example.hexagonal.infrastructure.application.rest.product;

import com.example.hexagonal.domain.product.model.Product;
import com.example.hexagonal.domain.product.port.in.ProductServicePort;
import com.example.hexagonal.infrastructure.application.rest.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private static final Long EMPTY_ID = null;
    private final ProductServicePort productServicePort;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productServicePort.getProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductDto productDto) {
        return productServicePort.addProduct(
                new Product(EMPTY_ID,productDto.getName(), productDto.getDescription()));
    }
}
