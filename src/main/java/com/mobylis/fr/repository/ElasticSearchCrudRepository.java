package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.elasticsearch.EsIndex;
import com.mobylis.fr.service.exception.ElasticSearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Service
public class ElasticSearchCrudRepository implements CrudRepository {

    private EsIndex esIndex;

    // Index
    private final static String INDEX_NAME = "products";

    // Fields
    private final static String FIELD_NAME = "name";
    private final static String FIELD_DESCRIPTION = "description";
    private final static String FIELD_BRAND = "brand";
    private final static String FIELD_PRICE = "price";
    private final static String FIELD_CATEGORY = "category";
    private final static String FIELD_DIMENSION = "dimension";


    @Autowired
    public ElasticSearchCrudRepository(EsIndex esIndex) {
        this.esIndex = esIndex;
    }


    @Override
    public Product save(@NotNull(message = "Product is null") Product product) {

        if (product.getCategory().getName() == null) throw new ElasticSearchException("Category is null ");

        IndexRequest indexRequest = new IndexRequest(INDEX_NAME, "doc")
                .source(FIELD_NAME, product.getName(),
                        FIELD_DESCRIPTION, product.getDescription(),
                        FIELD_BRAND, product.getBrand(),
                        FIELD_PRICE, product.getPrice(),
                        FIELD_CATEGORY, product.getCategory().getName(),
                        FIELD_DIMENSION, product.getDimension());

        try {

            // Call elasticSearch
            final IndexResponse index = esIndex.index(indexRequest);

            //  Checkout the indexResponse status
            if (index.getResult() != DocWriteResponse.Result.CREATED) throw new ElasticSearchException("Product is not properly index: " + product.toString());

            // Set ElasticSearch ID
            product.setElasticsearchId(index.getId());

        } catch (IOException e) {
            throw new ElasticSearchException("Fail to index: " + product.toString());
        }

        return product;
    }

    @Override
    public void delete(Product product) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX_NAME, "doc", product.getElasticsearchId());

        try {
            final DeleteResponse delete = esIndex.delete(deleteRequest);

            if (delete.getResult() != DocWriteResponse.Result.DELETED) throw new ElasticSearchException("Product is not properly deleted: " + product.toString());

        } catch (IOException e) {
            throw new ElasticSearchException("Fail while deleting: " + product.toString());
        }

    }

    @Override
    public Product update(Product product) {

        delete(product);

        return save(product);
    }

}