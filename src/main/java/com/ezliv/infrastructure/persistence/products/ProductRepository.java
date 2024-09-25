package com.ezliv.infrastructure.persistence.products;

import com.ezliv.infrastructure.persistence.products.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
