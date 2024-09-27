package com.ezliv.application.gateways;
import com.ezliv.domain.product.Product;
import java.util.List;

public interface ProductGateway {
    List<Product> createProducts(List<Product> products);

    Product updateProduct(String id, String name, String description, String price, String image);

    void deleteProduct(String id);

    Product getProduct(String id);

    List<Product> getProducts();
}
