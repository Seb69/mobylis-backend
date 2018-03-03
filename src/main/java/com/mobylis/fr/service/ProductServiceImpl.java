package com.mobylis.fr.service;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;
import com.mobylis.fr.repository.ElasticSearchRepository;
import com.mobylis.fr.repository.MysqlRepository;
import com.mobylis.fr.service.exception.ProductServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    // database repositories
    private MysqlRepository mysqlService;
    private ElasticSearchRepository elasticSearchService;

    // Conversion service
    private ConversionService conversionService;

    @Autowired
    public ProductServiceImpl(MysqlRepository mysqlService, ElasticSearchRepository elasticSearchService, ConversionService conversionService) {
        this.mysqlService = mysqlService;
        this.elasticSearchService = elasticSearchService;
        this.conversionService = conversionService;
    }


    @Override
    public ProductMysql createProduct(ProductView productCreationDTO) {


        final CompletableFuture<ProductMysql> saveProduct = CompletableFuture
                .supplyAsync(() -> {
                    final ProductEs convert = conversionService.convert(productCreationDTO, ProductEs.class);
                    final String savedID = elasticSearchService.save(convert);
                    productCreationDTO.setElasticsearchId(savedID);
                    return savedID;
                })
                .thenApply((elasticsearchID) -> {
                    final ProductMysql convert = conversionService.convert(productCreationDTO, ProductMysql.class);
                    return mysqlService.save(convert);
                })
                .exceptionally((ex) -> {
                    if (productCreationDTO.getElasticsearchId() != null) {
                        elasticSearchService.delete(productCreationDTO.getElasticsearchId());
                    }
                    throw new ProductServiceException("Failed to save product in Mysql database", ex);
                });

        try {
            return saveProduct.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new ProductServiceException("Failed while persisting Product", e);
        }
    }


    @Override
    public void deleteProduct(Long id) {

        final ProductMysql productMysql= mysqlService.findById(id);

        final CompletableFuture<Void> deleteProduct = CompletableFuture
                .runAsync(() -> {
                    elasticSearchService.delete(productMysql.getElasticsearchId());
                    productMysql.setElasticsearchId(null);
                })
                .thenRun(() -> {
                    // Persist in Mysql Database
                    mysqlService.delete(productMysql.getId());
                })
                .exceptionally((ex) -> {
                    if (productMysql.getElasticsearchId() == null) {
                        final ProductEs convert = conversionService.convert(productMysql, ProductEs.class);
                        elasticSearchService.save(convert);
                    }
                    throw new ProductServiceException("Failed while deleting Product", ex);
                });

        try {
            deleteProduct.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new ProductServiceException("Failed while deleting Product", e);
        }
    }

    @Override
    public ProductMysql updateProduct(ProductMysql product) {
        // Mysql
        final ProductMysql update = mysqlService.update(product);

        // ElasticSearch
        elasticSearchService.update(product);

        return update;
    }

    @Override
    public ProductMysql getProduct(Long id) {
        return mysqlService.findById(id);
    }

}