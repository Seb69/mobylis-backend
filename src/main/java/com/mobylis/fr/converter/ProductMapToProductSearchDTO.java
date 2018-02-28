package com.mobylis.fr.converter;

import com.mobylis.fr.dto.ProductSearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class ProductMapToProductSearchDTO implements Converter<Map,ProductSearchDTO> {


    @Override
    public ProductSearchDTO convert(Map source) {

        ProductSearchDTO productSearchDTO = new ProductSearchDTO();

        productSearchDTO.setName(source.get("name").toString());
        productSearchDTO.setDescription(source.get("description").toString());
        productSearchDTO.setBrand(source.get("brand").toString());
        productSearchDTO.setCategory(source.get("category").toString());
        productSearchDTO.setDimension(source.get("dimension").toString());
//        productSearchDTO.setImages(source.get("images").toString());
        return productSearchDTO;
    }
}
