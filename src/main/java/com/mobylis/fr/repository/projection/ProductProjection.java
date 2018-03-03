package com.mobylis.fr.repository.projection;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.ProductMysql;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Projection(name = "ProductProjection",types = ProductMysql.class)
public interface ProductProjection {

    Long getId();

    String getDimension();

    String getName();

    String getBrand();

    BigDecimal getPrice();

    Category getCategory();

    String getElasticsearchId();

}
