package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class MapToProductEsConverter implements Converter<Map, ProductEs> {


    @Override
    public ProductEs convert(Map source) {

        ProductEs product = new ProductEs();

        if ((source.get("name") != null)) {
            product.setName((String) source.get("name"));
        }
        if ((source.get("description") != null)) {
            product.setDescription((String) source.get("description"));
        }
        if ((source.get("brand") != null)) {
            product.setBrand((String) source.get("brand"));
        }
        if ((source.get("category") != null)) {
            product.setCategory((String) source.get("category"));
        }
        if ((source.get("dimension") != null)) {
            product.setDimension((String) source.get("dimension"));
        }
        if ((source.get("price") != null)) {
            product.setPrice((BigDecimal) source.get("price"));
        }
        if ((source.get("images") != null)) {
            product.setImages((List<String>) source.get("images"));
        }
        return product;
    }
}
