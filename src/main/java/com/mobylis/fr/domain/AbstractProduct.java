package com.mobylis.fr.domain;

import javax.persistence.*;

/**
 * @author ANDRE
 * @since 10/12/2017
 */
@MappedSuperclass
public abstract class AbstractProduct {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private String price;

}
