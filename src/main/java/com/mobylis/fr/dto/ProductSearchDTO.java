package com.mobylis.fr.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ANDRE
 * @since 27/02/2018
 */
public class ProductSearchDTO {

    private String name;

    private Double price;

    private String description;

    private String brand;

    private String dimension;

    private List<String> images = new ArrayList<>();

    private String category;

    @Override
    public String toString() {
        return "ProductSearchDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", dimension='" + dimension + '\'' +
                ", images=" + images +
                ", category='" + category + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
