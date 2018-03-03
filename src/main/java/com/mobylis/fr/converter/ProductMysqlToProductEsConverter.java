package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;
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

        productEs.setName(productEs.getName());
        productEs.setDescription(productEs.getDescription());
        productEs.setBrand(productEs.getBrand());
        productEs.setDimension(productEs.getDimension());
        productEs.setPrice(productEs.getPrice());
        productEs.setImages(productEs.getImages());

        if (product.getCategory().getName() != null) {
            productEs.setCategory(product.getCategory().getName());
        }

        return productEs;
    }
}
