package com.ezliv.application.usecases.products;

import com.ezliv.application.gateways.ProductGateway;
import com.ezliv.application.usecases.NoParams;
import com.ezliv.application.usecases.UseCase;
import com.ezliv.domain.product.Product;

import java.util.List;

public class GetProductsUseCase extends UseCase<List<Product>, NoParams> {
    private final ProductGateway productGateway;

    public GetProductsUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> execute(NoParams params) {
        return productGateway.getProducts();
    }
}
