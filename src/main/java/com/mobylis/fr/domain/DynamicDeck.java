package com.mobylis.fr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Table(name = "DYNAMIC_DESK")
@Entity
public class DynamicDeck extends AbstractProduct {

    @Column(name = "DIMENSION")
    private String dimension;

}