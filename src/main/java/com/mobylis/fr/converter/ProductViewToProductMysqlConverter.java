package com.mobylis.fr.converter;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class ProductViewToProductMysqlConverter implements Converter<ProductView, ProductMysql> {


    @Override
    public ProductMysql convert(ProductView productCreationDTO) {

        ProductMysql product = new ProductMysql();

        product.setName(productCreationDTO.getName());
        product.setDescription(productCreationDTO.getDescription());
        product.setBrand(productCreationDTO.getBrand());
        product.setDimension(productCreationDTO.getDimension());
        product.setPrice(productCreationDTO.getPrice());
        product.setImages(productCreationDTO.getImages());
        product.setElasticsearchId(productCreationDTO.getElasticsearchId());
        Category category = new Category();
        category.setName(productCreationDTO.getCategory());

        product.setCategory(category);

        return product;
    }
}
