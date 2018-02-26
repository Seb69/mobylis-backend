package com.mobylis.fr.mock;

import com.mobylis.fr.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
public class Category_Mock {

    public static Category create() {
        Category category = new Category();
        category.setName("SEATS");
        category.setId(4L);
        return category;
    }

}
