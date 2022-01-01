package com.example.hexagonal.infrastructure.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.hexagonal.infrastructure.persistence.database"})
@EntityScan(basePackages = {"com.example.hexagonal.infrastructure.persistence.database"})
@ComponentScan(basePackages = {"com.example.hexagonal.infrastructure"})
public class HexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalApplication.class, args);
    }

}
