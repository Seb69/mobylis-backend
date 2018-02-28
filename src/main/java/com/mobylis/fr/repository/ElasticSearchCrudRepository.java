package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Category;
import com.mobylis.fr.domain.Product;
import com.mobylis.fr.dto.ProductSearchDTO;
import com.mobylis.fr.elasticsearch.EsIndex;
import com.mobylis.fr.service.exception.ElasticSearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.document.DocumentField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@Service
public class ElasticSearchCrudRepository implements CrudRepository {

    private EsIndex esIndex;

    // Index
    private final static String INDEX_NAME = "products";
    private final static String INDEX_TYPE = "doc";

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

        // Call elasticSearch
        final IndexResponse index = esIndex.index(indexRequest);

        //  Checkout the indexResponse status
        if (index.getResult() != DocWriteResponse.Result.CREATED)
            throw new ElasticSearchException("Product is not properly index: " + product.toString());

        // Set ElasticSearch ID
        product.setElasticsearchId(index.getId());


        return product;
    }

    @Override
    public void delete(Product product) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX_NAME, "doc", product.getElasticsearchId());

        final DeleteResponse delete = esIndex.delete(deleteRequest);

        if (delete.getResult() != DocWriteResponse.Result.DELETED)
            throw new ElasticSearchException("Product is not properly deleted: " + product.toString());

    }

    @Override
    public Product update(Product product) {

        delete(product);

        return save(product);
    }

    public Mono<Product> get(String id) {

        GetRequest getRequest = new GetRequest(INDEX_NAME, INDEX_TYPE, id);

        final Mono<GetResponse> getResponseMono = esIndex.get(getRequest);

        final Mono<Map<String, Object>> sourceMapMono = getResponseMono.map(GetResponse::getSourceAsMap);

        sourceMapMono.subscribe(sourceMap -> {
            Product product = new Product();
            ProductSearchDTO productSearchDTO = new ProductSearchDTO();
            product.setCategory((Category) sourceMap.get("category"));
        });
//        getResponseMono.subscribe(getResponse -> {
//            System.out.println(getResponse);
//        });

        return null;
    }

}