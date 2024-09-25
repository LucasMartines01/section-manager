package com.ezliv.domain.product;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private BigDecimal promotionalPrice;
    private Boolean isFavorite;
    private Boolean isLastUnits;
    private BigDecimal quantity;
    private String measure;
    private List<Variation> variations;

    public Product(String name, String imageUrl, String description, BigDecimal price, BigDecimal promotionalPrice, BigDecimal quantity, String measure, List<Variation> variations) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.isFavorite = false;
        this.isLastUnits = quantity.compareTo(BigDecimal.valueOf(5)) < 0;
        this.quantity = quantity;
        this.measure = measure;
        this.variations = variations;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public Boolean getLastUnits() {
        return isLastUnits;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public List<Variation> getVariations() {
        return variations;
    }

}
