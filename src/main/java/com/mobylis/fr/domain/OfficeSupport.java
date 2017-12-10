package com.mobylis.fr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ANDRE
 * @since 10/12/2017
 */
@Table(name = "OFFICE_SUPPORT")
@Entity
public class OfficeSupport extends AbstractProduct {

    @Column(name = "ILLNESS")
    private String illness;
}
