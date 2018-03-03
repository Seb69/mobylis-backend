package com.mobylis.fr.mock;

import com.mobylis.fr.domain.ProductMysql;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
public class Product_Mock {

    public static ProductMysql createA() {

        ProductMysql desk = new ProductMysql();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable. " +
                "Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

        desk.setCategory(Category_Mock.create());
        return desk;
    }


    public static ProductMysql createB() {

        ProductMysql desk = new ProductMysql();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

        desk.setCategory(Category_Mock.create());

        return desk;
    }
}
