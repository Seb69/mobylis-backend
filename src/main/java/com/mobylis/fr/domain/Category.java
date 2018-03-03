package com.mobylis.fr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Table(name = "CATEGORY")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCT_ID")
    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ProductMysql> productSet = new HashSet<>();

    public void addProduct(ProductMysql product) {
        productSet.add(product);
        product.setCategory(this);
    }

    public void removeProduct(ProductMysql product) {
        productSet.remove(product);
        product.setCategory(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
