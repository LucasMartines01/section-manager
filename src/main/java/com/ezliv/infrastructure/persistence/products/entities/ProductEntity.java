package com.ezliv.infrastructure.persistence.products.entities;

import com.ezliv.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "product")
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private BigDecimal promotionalPrice;
    private Boolean isFavorite;
    private Boolean isLastUnits;
    private BigDecimal quantity;
    private String measure;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id_variation")
    private List<VariationEntity> variations;

    public ProductEntity(Product product) {
        this.name = product.getName();
        this.imageUrl = product.getImageUrl();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.promotionalPrice = product.getPromotionalPrice();
        this.isFavorite = product.getFavorite();
        this.isLastUnits = product.getLastUnits();
        this.quantity = product.getQuantity();
        this.measure = product.getMeasure();

    }
}
