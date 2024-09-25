package com.ezliv.application.usecases.products;

import com.ezliv.application.gateways.ProductGateway;
import com.ezliv.application.usecases.UseCase;
import com.ezliv.domain.product.Product;

import java.util.List;

public class CreateProductsUseCase extends UseCase<List<Product>, List<Product>> {

    private final ProductGateway productGateway;

    public CreateProductsUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> execute(List<Product> params) {
        return productGateway.createProducts(params);
    }
}
