package com.ezliv.application.usecases.products;
import com.ezliv.application.gateways.ProductGateway;
import com.ezliv.application.usecases.UseCase;
import com.ezliv.domain.product.Product;

public class GetProductUseCase extends UseCase<Product, String> {
    private final ProductGateway productGateway;

    public GetProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product execute(String params) {
        return productGateway.getProduct(params);
    }
}
