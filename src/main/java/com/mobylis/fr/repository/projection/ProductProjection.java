package com.mobylis.fr.repository.projection;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Projection(name = "ProductProjection",types = Product.class)
public interface ProductProjection {

    Long getId();

    String getDimension();

    String getName();

    String getBrand();

    BigDecimal getPrice();

    Category getCategory();

    String getElasticsearchId();

}
