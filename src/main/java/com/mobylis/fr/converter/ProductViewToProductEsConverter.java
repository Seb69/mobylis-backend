package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.dto.ProductView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class ProductViewToProductEsConverter implements Converter<ProductView, ProductEs> {


    @Override
    public ProductEs convert(ProductView productCreationDTO) {

        ProductEs productEs = new ProductEs();

        productEs.setName(productCreationDTO.getName());
        productEs.setDescription(productCreationDTO.getDescription());
        productEs.setBrand(productCreationDTO.getBrand());
        productEs.setDimension(productCreationDTO.getDimension());
        productEs.setPrice(productCreationDTO.getPrice());
        productEs.setImages(productCreationDTO.getImages());
        productEs.setCategory(productCreationDTO.getCategory());

        return productEs;
    }
}
