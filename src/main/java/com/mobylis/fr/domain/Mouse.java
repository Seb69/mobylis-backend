package com.mobylis.fr.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ANDRE
 * @since 10/12/2017
 */
@Table(name = "MOUSE")
@Entity
public class Mouse extends AbstractProduct {

    @Column(name = "ILLNESS")
    private String illness;

}
