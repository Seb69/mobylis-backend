package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductCreationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class ProductMysqlToProductViewConverter implements Converter<ProductMysql, ProductCreationDTO> {


    @Override
    public ProductCreationDTO convert(ProductMysql product) {

        ProductCreationDTO productView = new ProductCreationDTO();


        productView.setId(product.getId());
        productView.setName(product.getName());
        productView.setDescription(product.getDescription());
        productView.setBrand(product.getBrand());
        productView.setDimension(product.getDimension());
        productView.setPrice(product.getPrice());
        productView.setImages(product.getImages());
        productView.setElasticsearchId(product.getElasticsearchId());

        productView.setCategory(product.getCategory().getName());

        return productView;
    }
}
