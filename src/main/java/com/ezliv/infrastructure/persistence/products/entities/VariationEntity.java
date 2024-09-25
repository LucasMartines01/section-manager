package com.ezliv.infrastructure.persistence.products.entities;

import com.ezliv.domain.product.Variation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_variations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VariationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;

    public VariationEntity(Variation variation) {
        this.name = variation.getName();
        this.imageUrl = variation.getImageUrl();
        this.description = variation.getDescription();
        this.price = variation.getPrice();
        this.quantity = variation.getQuantity();
    }
}
