package com.ezliv.infrastructure.controllers.products.dtos;

import com.ezliv.domain.product.Variation;

import java.math.BigDecimal;

public record VariationResponseDTO(
        String name,
        String imageUrl,
        String description,
        BigDecimal price,
        BigDecimal quantity
) {
    public VariationResponseDTO(Variation variation) {
        this(
                variation.getName(),
                variation.getImageUrl(),
                variation.getDescription(),
                variation.getPrice(),
                variation.getQuantity()
        );
    }
}
