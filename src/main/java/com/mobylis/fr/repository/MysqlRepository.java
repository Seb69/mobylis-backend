package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.domain.SubCategory;
import com.mobylis.fr.repository.exception.MysqlRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Repository
public class MysqlRepository {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public MysqlRepository(ProductRepository productRepository, CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }


    public ProductMysql save(ProductMysql product) {

        if (product.getCategory().getName() == null || product.getSubCategory().getName() == null) {
            throw new MysqlRepositoryException("Category or Subcateory cannot be null");
        }

        final Category category = categoryRepository.findOneByName(product.getCategory().getName());
        final SubCategory subCategory = subCategoryRepository.findOneByName(product.getSubCategory().getName());

        if (category == null) throw new MysqlRepositoryException("Category does not exists");
        if (subCategory == null) throw new MysqlRepositoryException("SubCategory does not exists");

        // Add the relationship between Category, SubCategory and Product
        product.setSubCategory(subCategory);
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
