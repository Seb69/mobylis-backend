package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.Product;
import com.mobylis.fr.service.exception.CategoryNotFound;
import com.mobylis.fr.service.exception.PersistingFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Repository
public class MysqlCrudRepository implements CrudRepository {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public MysqlCrudRepository(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product save(@NotNull(message = "Product is null") Product product) {

        final Category byName = categoryRepository.findOneByName(product.getCategory().getName());

        if (byName == null) throw new CategoryNotFound(product.getCategory().getName() + " does not exists");

        byName.addProduct(product);

        final Product save = productRepository.save(product);

        if (save == null) throw new PersistingFailureException("Failed during saving " + product.toString());

        return save;
    }

    @Override
    public void delete(@NotNull(message = "Product is null") Product product) {

        productRepository.delete(product);
    }

    @Override
    public Product update(@NotNull(message = "Product is null") Product product) {

        return save(product);
    }

}
