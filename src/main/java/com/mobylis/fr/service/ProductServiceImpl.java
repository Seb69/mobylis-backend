package com.mobylis.fr.service;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductCreationDTO;
import com.mobylis.fr.repository.ElasticSearchRepository;
import com.mobylis.fr.repository.MysqlRepository;
import com.mobylis.fr.service.exception.ProductServiceException;
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
    public ProductCreationDTO createProduct(ProductCreationDTO productView) {


        final CompletableFuture<ProductCreationDTO> saveProduct = CompletableFuture
                .supplyAsync(() -> {
                    final ProductEs convert = conversionService.convert(productView, ProductEs.class);
                    final String savedID = elasticSearchService.save(convert);
                    productView.setElasticsearchId(savedID);
                    return savedID;
                })
                .thenApply((elasticsearchID) -> {
                    final ProductMysql convert = conversionService.convert(productView, ProductMysql.class);
                    final ProductMysql save = mysqlService.save(convert);
                    return conversionService.convert(save, ProductCreationDTO.class);
                })
                .exceptionally((ex) -> {
                    if (productView.getElasticsearchId() != null) {
                        elasticSearchService.delete(productView.getElasticsearchId());
                    }
                    throw new ProductServiceException("Failed to save product in database", ex);
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
    public ProductCreationDTO updateProduct(ProductCreationDTO productView) {

        // Convert
        final ProductEs productEs = conversionService.convert(productView, ProductEs.class);
        // ElasticSearch
        final ProductEs productEsUpdated = elasticSearchService.update(productEs, productView.getElasticsearchId());

        final ProductMysql convert = conversionService.convert(productView, ProductMysql.class);
        final ProductMysql update = mysqlService.update(convert);

        return  conversionService.convert(update, ProductCreationDTO.class);
    }

    @Override
    public ProductCreationDTO getProduct(Long id) {
        final ProductMysql byId = mysqlService.findById(id);
        return conversionService.convert(byId, ProductCreationDTO.class);
    }

}