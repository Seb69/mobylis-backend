package com.mobylis.fr.mock;

import com.mobylis.fr.dto.ProductCreationDTO;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
public class ProductCreationDTO_Mock {

    public static ProductCreationDTO createA() {

        ProductCreationDTO productCreationDTO = new ProductCreationDTO();

        productCreationDTO.setName("Bureau Open Space");
        productCreationDTO.setBrand("MOBEL LINEA");
        productCreationDTO.setDescription("Mobilier très robuste et comfortable. " +
                "Mobilier très robuste et comfortable.");
        productCreationDTO.setPrice(BigDecimal.valueOf(570L));

        productCreationDTO.setCategory("SIEGES");
        return productCreationDTO;
    }


    public static ProductCreationDTO createB() {

        ProductCreationDTO productCreationDTO = new ProductCreationDTO();

        productCreationDTO.setName("Bureau Open Space");
        productCreationDTO.setBrand("MOBEL LINEA");
        productCreationDTO.setDescription("Mobilier très robuste et comfortable. " +
                "Mobilier très robuste et comfortable.");
        productCreationDTO.setPrice(BigDecimal.valueOf(570L));

        productCreationDTO.setCategory("SIEGES");

        return productCreationDTO;
    }
}
