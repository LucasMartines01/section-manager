package com.ezliv.infrastructure.controllers.products;

import com.ezliv.domain.product.Product;
import com.ezliv.domain.product.Variation;
import com.ezliv.infrastructure.controllers.products.dtos.ProductRequestDTO;
import com.ezliv.infrastructure.controllers.products.dtos.ProductResponseDTO;
import com.ezliv.infrastructure.controllers.products.dtos.VariationRequestDTO;

import java.util.stream.Collectors;

public class ProductUtils {

    public static Product toDomain(ProductRequestDTO dto) {
        return new Product(
                dto.name(),
                dto.imageUrl(),
                dto.description(),
                dto.price(),
                dto.promotionalPrice(),
                dto.quantity(),
                dto.measure(),
                dto.variations().stream().map(ProductUtils::toVariationDomain).collect(Collectors.toList())
        );
    }

    public static Variation toVariationDomain(VariationRequestDTO dto) {
        return new Variation(
                dto.name(),
                dto.imageUrl(),
                dto.description(),
                dto.price(),
                dto.quantity()
        );
    }

    public static ProductResponseDTO toDto(Product product) {
        return new ProductResponseDTO(
                product
        );
    }
}
