package com.mobylis.fr.service;

import com.mobylis.fr.dto.ProductCreationDTO;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public interface ProductService {
    ProductCreationDTO createProduct(ProductCreationDTO productView);
    void deleteProduct(Long id);
    ProductCreationDTO updateProduct(ProductCreationDTO product);
    ProductCreationDTO getProduct(Long id);
}
