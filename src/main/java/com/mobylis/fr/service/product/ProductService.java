package com.mobylis.fr.service.product;

import com.mobylis.fr.domain.Product;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public interface ProductService {
    Mono<Boolean> createProduct(Product productView);
    Mono<Boolean> deleteProduct(String id);
    Mono<Boolean> updateProduct(Product product, String id);
    Mono<List<Product>> getProducts();
}
