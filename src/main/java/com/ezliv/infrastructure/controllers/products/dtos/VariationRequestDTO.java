package com.ezliv.infrastructure.controllers.products.dtos;

import java.math.BigDecimal;

public record VariationRequestDTO(
        String name,
        String imageUrl,
        String description,
        BigDecimal price,
        BigDecimal quantity
) {
}
