package com.mobylis.fr.mock;

import com.mobylis.fr.domain.Product;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
public class Product_Mock {

    public static Product createA() {

        Product productCreationDTO = new Product();

        productCreationDTO.setName("Bureau Open Space");
        productCreationDTO.setBrand("MOBEL LINEA");
        productCreationDTO.setDescription("Mobilier très robuste et comfortable. " +
                "Mobilier très robuste et comfortable.");
        productCreationDTO.setPrice(BigDecimal.valueOf(570L));

        productCreationDTO.setCategory("SIEGES");
        return productCreationDTO;
    }


    public static Product createB() {

        Product productCreationDTO = new Product();

        productCreationDTO.setName("Bureau Open Space");
        productCreationDTO.setBrand("MOBEL LINEA");
        productCreationDTO.setDescription("Mobilier très robuste et comfortable. " +
                "Mobilier très robuste et comfortable.");
        productCreationDTO.setPrice(BigDecimal.valueOf(570L));

        productCreationDTO.setCategory("SIEGES");

        return productCreationDTO;
    }
}
