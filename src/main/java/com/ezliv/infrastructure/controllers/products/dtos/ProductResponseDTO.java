package com.ezliv.infrastructure.controllers.products.dtos;

import com.ezliv.domain.product.Product;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDTO(String name,
                                 String imageUrl,
                                 String description,
                                 BigDecimal price,
                                 BigDecimal promotionalPrice,
                                 Boolean isFavorite,
                                 Boolean isLastUnits,
                                 BigDecimal quantity,
                                 String measure,
                                 List<VariationResponseDTO> variations

) {
    public ProductResponseDTO(Product product) {
        this(
                product.getName(),
                product.getImageUrl(),
                product.getDescription(),
                product.getPrice(),
                product.getPromotionalPrice(),
                product.getFavorite(),
                product.getLastUnits(),
                product.getQuantity(),
                product.getMeasure(),
                product.getVariations().stream()
                        .map(VariationResponseDTO::new)
                        .toList()
        );
    }
}
