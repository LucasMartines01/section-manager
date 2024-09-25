package com.ezliv.infrastructure.gateways.products;

import com.ezliv.domain.product.Product;
import com.ezliv.domain.product.Variation;
import com.ezliv.infrastructure.persistence.products.entities.ProductEntity;
import com.ezliv.infrastructure.persistence.products.entities.VariationEntity;

public class ProductMapper {
    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(product);
    }

    public static Product toDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getName(),
                productEntity.getImageUrl(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getPromotionalPrice(),
                productEntity.getQuantity(),
                productEntity.getMeasure(),
                productEntity.getVariations().stream()
                        .map(ProductMapper::toDomainVariation)
                        .toList()
        );
    }

    public static Variation toDomainVariation(VariationEntity variationEntity) {
        return new Variation(
                variationEntity.getName(),
                variationEntity.getImageUrl(),
                variationEntity.getDescription(),
                variationEntity.getPrice(),
                variationEntity.getQuantity()
        );
    }

}
