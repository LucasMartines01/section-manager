package com.ezliv.domain.product;

import java.math.BigDecimal;

public class Variation {
    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;

    public Variation(String name, String imageUrl, String description, BigDecimal price, BigDecimal quantity) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
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

    public BigDecimal getQuantity() {
        return quantity;
    }
}
