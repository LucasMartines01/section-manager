package com.ezliv.infrastructure.controllers.products;

import com.ezliv.application.usecases.NoParams;
import com.ezliv.application.usecases.products.CreateProductsUseCase;
import com.ezliv.application.usecases.products.GetProductsUseCase;
import com.ezliv.domain.product.Product;
import com.ezliv.infrastructure.controllers.DefaultBody;
import com.ezliv.infrastructure.controllers.products.dtos.ProductRequestDTO;
import com.ezliv.infrastructure.controllers.products.dtos.ProductResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductsUseCase createProductsUseCase;
    private final GetProductsUseCase getProductsUseCase;

    public ProductController(CreateProductsUseCase createProductsUseCase, GetProductsUseCase getProductsUseCase) {
        this.createProductsUseCase = createProductsUseCase;
        this.getProductsUseCase = getProductsUseCase;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        List<Product> products = getProductsUseCase.execute(new NoParams());
        return ResponseEntity.ok(products.stream().map(ProductUtils::toDto).toList());
    }

    @PostMapping
    public ResponseEntity<List<ProductResponseDTO>> createProducts(@RequestBody DefaultBody<List<ProductRequestDTO>> request) {
        List<Product> createdProducts = createProductsUseCase.execute(request.getData().stream().map(ProductUtils::toDomain).toList());
        return ResponseEntity.ok(createdProducts.stream().map(ProductUtils::toDto).toList());
    }
}
