package com.mobylis.fr.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
@Data
public class Product {

    private String name;

    private String description;

    private BigDecimal price;

    private String brand;

    private String dimension;

    private List<String> images = new ArrayList<>();

    private String category;

    private String subCategory;

}
