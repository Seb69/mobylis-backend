package com.mobylis.fr.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ANDRE
 * @since 02/03/2018
 */
public class ProductView {

    private String name;

    private String description;

    private BigDecimal price;

    private String brand;

    private String dimension;

    private String elasticsearchId;

    private List<String> images = new ArrayList<>();

    @NotNull
    private String category;

    @Override
    public String toString() {
        return "ProductCreationDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", dimension='" + dimension + '\'' +
                ", elasticsearchId='" + elasticsearchId + '\'' +
                ", images=" + images +
                ", category='" + category + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getElasticsearchId() {
        return elasticsearchId;
    }

    public void setElasticsearchId(String elasticsearchId) {
        this.elasticsearchId = elasticsearchId;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
