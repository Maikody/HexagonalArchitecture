package com.example.hexagonal.infrastructure.application.rest.product.dto;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class ProductDto {
    @Length(min = 4) String name;
    @Length(min = 4) String description;
}
