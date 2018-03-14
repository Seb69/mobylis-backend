package com.mobylis.fr.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ANDRE
 * @since 27/02/2018
 */
public class ProductSearchDTO {

    // elasticsearch ID
    private String id;

    private String name;

    private BigDecimal price;

    private List<String> images = new ArrayList<>();

    private String category;

    @Override
    public String toString() {
        return "ProductSearchDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", category='" + category + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
