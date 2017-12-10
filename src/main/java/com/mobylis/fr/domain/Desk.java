package com.mobylis.fr.domain;


import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author ANDRE
 * @since 10/12/2017
 */
@Table(name = "DESK")
public class Desk extends AbstractProduct {

    @Column(name = "DIMENSION")
    private String dimension;


}
