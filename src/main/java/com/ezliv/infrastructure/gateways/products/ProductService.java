package com.ezliv.infrastructure.gateways.products;

import com.ezliv.application.gateways.ProductGateway;
import com.ezliv.domain.product.Product;
import com.ezliv.infrastructure.persistence.products.ProductRepository;
import com.ezliv.infrastructure.persistence.products.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductGateway {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> createProducts(List<Product> products) {
        List<ProductEntity> productEntities = products.stream()
                .map(ProductMapper::toEntity)
                .toList();

        productRepository.saveAll(productEntities);

        return products;
    }

    @Override
    public Product updateProduct(String id, String name, String description, String price, String image) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public Product getProduct(String id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();

        return productEntities.stream()
                .map(ProductMapper::toDomain)
                .toList();
    }
}
