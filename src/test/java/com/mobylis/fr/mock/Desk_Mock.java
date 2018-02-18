package com.mobylis.fr.mock;

import com.mobylis.fr.domain.Desk;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
public class Desk_Mock {

    public static Desk createA() {

        Desk desk = new Desk();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

        return desk;
    }


    public static Desk createB() {

        Desk desk = new Desk();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

        return desk;
    }
}
