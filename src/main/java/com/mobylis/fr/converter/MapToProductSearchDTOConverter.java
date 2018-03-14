package com.mobylis.fr.converter;

import com.mobylis.fr.dto.ProductSearchDTO;
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
public class MapToProductSearchDTOConverter implements Converter<Map, ProductSearchDTO> {


    @Override
    public ProductSearchDTO convert(Map source) {

        ProductSearchDTO productSearchDTO = new ProductSearchDTO();

        if ((source.get("name") != null)) {
            productSearchDTO.setName((String) source.get("name"));
        }
        if ((source.get("category") != null)) {
            productSearchDTO.setCategory((String) source.get("category"));
        }
        if ((source.get("price") != null)) {
            productSearchDTO.setPrice(new BigDecimal((String) source.get("price")));
        }
        if ((source.get("images") != null)) {
            productSearchDTO.setImages((List<String>) source.get("images"));
        }
        return productSearchDTO;
    }
}
