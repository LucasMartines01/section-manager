package com.ezliv.infrastructure.controllers.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequestDTO(
        @NotBlank String name,
        @NotBlank String imageUrl,
        @NotBlank String description,
        @NotNull BigDecimal price,
        @NotNull BigDecimal promotionalPrice,
        @NotNull BigDecimal quantity,
        @NotBlank String measure,
        List<VariationRequestDTO> variations
) {
}
