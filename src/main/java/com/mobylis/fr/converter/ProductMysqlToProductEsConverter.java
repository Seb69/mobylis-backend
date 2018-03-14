package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class ProductMysqlToProductEsConverter implements Converter<ProductMysql, ProductEs> {


    @Override
    public ProductEs convert(ProductMysql product) {

        ProductEs productEs = new ProductEs();

        productEs.setName(product.getName());
        productEs.setDescription(product.getDescription());
        productEs.setBrand(product.getBrand());
        productEs.setDimension(product.getDimension());
        productEs.setPrice(product.getPrice());
        productEs.setImages(product.getImages());

        if (product.getCategory().getName() != null) {
            productEs.setCategory(product.getCategory().getName());
        }

        return productEs;
    }
}
