package com.mobylis.fr.converter;

import com.mobylis.fr.dto.ProductCreationDTO;
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
public class MapToProductViewConverter implements Converter<Map, ProductCreationDTO> {


    @Override
    public ProductCreationDTO convert(Map source) {

        ProductCreationDTO productView = new ProductCreationDTO();

        if ((source.get("name") != null)) {
            productView.setName((String) source.get("name"));
        }
        if ((source.get("description") != null)) {
            productView.setDescription((String) source.get("description"));
        }
        if ((source.get("brand") != null)) {
            productView.setBrand((String) source.get("brand"));
        }
        if ((source.get("category") != null)) {
            productView.setCategory((String) source.get("category"));
        }
        if ((source.get("subCategory") != null)) {
            productView.setSubCategory((String) source.get("subCategory"));
        }
        if ((source.get("dimension") != null)) {
            productView.setDimension((String) source.get("dimension"));
        }
        if ((source.get("price") != null)) {
            productView.setPrice(new BigDecimal((String) source.get("price")));
        }
        if ((source.get("images") != null)) {
            productView.setImages((List<String>) source.get("images"));
        }
        return productView;
    }
}
