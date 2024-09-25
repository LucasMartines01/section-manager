package com.ezliv.config;

import com.ezliv.application.gateways.ProductGateway;
import com.ezliv.application.usecases.products.CreateProductsUseCase;
import com.ezliv.application.usecases.products.GetProductsUseCase;
import com.ezliv.infrastructure.controllers.products.ProductUtils;
import com.ezliv.infrastructure.gateways.products.ProductService;
import com.ezliv.infrastructure.persistence.products.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjection {

    @Bean
    CreateProductsUseCase createProductsUseCase(ProductGateway productGateway) {
        return new CreateProductsUseCase(productGateway);
    }

    @Bean
    GetProductsUseCase getProductsUseCase(ProductGateway productGateway) {
        return new GetProductsUseCase(productGateway);
    }

    @Bean
    ProductUtils productUtils() {
        return new ProductUtils();
    }

    @Bean
    ProductGateway productGateway(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
