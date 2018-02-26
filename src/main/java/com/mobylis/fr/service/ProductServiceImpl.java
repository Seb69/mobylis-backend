package com.mobylis.fr.service;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.repository.ElasticSearchCrudRepository;
import com.mobylis.fr.repository.MysqlCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    // database repositories
    private MysqlCrudRepository mysqlService;
    private ElasticSearchCrudRepository elasticSearchService;

    @Autowired
    public ProductServiceImpl(MysqlCrudRepository mysqlService, ElasticSearchCrudRepository elasticSearchService) {
        this.mysqlService = mysqlService;
        this.elasticSearchService = elasticSearchService;
    }

    @Override
    public void createProduct(Product product) {

        // Persist in ElasticSearch Database
        final Product save = elasticSearchService.save(product);

        // Persist in Mysql Database
        mysqlService.save(save);
    }

    @Override
    public void deleteProduct(Product product) {

        // Persist in Mysql Database
        mysqlService.delete(product);

        // Persist in ElasticSearch Database
        elasticSearchService.delete(product);
    }

    @Override
    public void updateProduct(Product product) {
        // Mysql
        mysqlService.update(product);

        // ElasticSearch
        elasticSearchService.update(product);
    }

}