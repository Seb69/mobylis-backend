package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class ProductMysqlToProductViewConverter implements Converter<ProductMysql, ProductView> {


    @Override
    public ProductView convert(ProductMysql product) {

        ProductView productCreationDTO = new ProductView();

        productCreationDTO.setName(productCreationDTO.getName());
        productCreationDTO.setDescription(productCreationDTO.getDescription());
        productCreationDTO.setBrand(productCreationDTO.getBrand());
        productCreationDTO.setDimension(productCreationDTO.getDimension());
        productCreationDTO.setPrice(productCreationDTO.getPrice());
        productCreationDTO.setImages(productCreationDTO.getImages());
        productCreationDTO.setElasticsearchId(productCreationDTO.getElasticsearchId());

        productCreationDTO.setCategory(product.getCategory().getName());

        return productCreationDTO;
    }
}
