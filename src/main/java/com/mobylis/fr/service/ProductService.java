package com.mobylis.fr.service;

import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public interface ProductService {
    ProductMysql createProduct(ProductView productCreationDTO);
    void deleteProduct(Long id);
    ProductMysql updateProduct(ProductMysql product);
    ProductMysql getProduct(Long id);
}
