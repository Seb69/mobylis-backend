package com.mobylis.fr.service;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.service.exception.CategoryNotFound;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public interface ProductService {
    void createProduct(Product product);
    void deleteProduct(Product product);
    void updateProduct(Product product);
}
