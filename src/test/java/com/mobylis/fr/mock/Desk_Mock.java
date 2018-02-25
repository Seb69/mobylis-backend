package com.mobylis.fr.mock;

import com.mobylis.fr.domain.Deck;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
public class Desk_Mock {

    public static Deck createA() {

        Deck desk = new Deck();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable. " +
                "Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

        return desk;
    }


    public static Deck createB() {

        Deck desk = new Deck();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

        return desk;
    }
}
