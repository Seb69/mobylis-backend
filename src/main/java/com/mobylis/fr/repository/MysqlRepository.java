package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.repository.exception.MysqlRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Repository
public class MysqlRepository {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MysqlRepository(ProductRepository productRepository, CategoryRepository categoryRepository, ConversionService conversionService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductMysql save(ProductMysql product) {

        final Category category = categoryRepository.findOneByName(product.getCategory().getName());

        if (category == null) throw new MysqlRepositoryException("Category does not exists");

        // Add the relationship between Category and Product
//        category.addProduct(product);
        product.setCategory(category);

        // Save in mysql
        return productRepository.save(product);
    }

    public void delete(Long id) {

        productRepository.deleteById(id);
    }

    public ProductMysql update(ProductMysql product) {

        return save(product);
    }

    public ProductMysql findById(Long id) {
        final Optional<ProductMysql> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new MysqlRepositoryException("Product not found");
        }
    }

}
