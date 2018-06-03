package com.mobylis.fr.service.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobylis.fr.domain.Product;
import com.mobylis.fr.service.elasticsearch.EsIndexImpl;
import com.mobylis.fr.service.exception.ProductServiceException;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.ShardSearchFailure;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    // Index
    private final static String INDEX_NAME = "products";
    private final static String INDEX_TYPE = "docs";

    // Elasticsearch
    private EsIndexImpl esIndex;

    // Object Mapper
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ProductServiceImpl(EsIndexImpl esIndex) {
        this.esIndex = esIndex;
    }


    @Override
    public Mono<Boolean> createProduct(Product product) {

        // Create index Request
        IndexRequest indexRequest = new IndexRequest(INDEX_NAME, INDEX_TYPE);

        // Convert product to Map
        Map convert = objectMapper.convertValue(product, Map.class);

        // Set map in index Request
        indexRequest.source(convert);

        // OPERATE
        return esIndex
                .index(indexRequest)
                .doOnError(throwable -> log.error("Error while indexing", throwable))
                .map(this::responseAnalyser);
    }


    @Override
    public Mono<Boolean> deleteProduct(String id) {

        // BUILD
        DeleteRequest deleteRequest = new DeleteRequest(INDEX_NAME, INDEX_TYPE, id);

        // OPERATE
        return esIndex
                .delete(deleteRequest)
                .map(this::responseAnalyser)
                .doOnError(throwable -> log.error("Error while indexing", throwable));

    }

    @Override
    public Mono<Boolean> updateProduct(Product product, String id) {

        Map map = objectMapper.convertValue(product, Map.class);

        // BUILD
        UpdateRequest updateRequest = new UpdateRequest(INDEX_NAME, INDEX_TYPE, id)
                .doc(map);

        // OPERATE
        return esIndex.update(updateRequest)
                .map(this::responseAnalyser)
                .doOnError(throwable -> log.error("Error while update request", throwable));
    }

    @Override
    public Mono<List<Product>> getProducts() {

        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        return esIndex.search(searchRequest)
                .map(searchResponse -> {

                    int totalShards = searchResponse.getTotalShards();
                    int successfulShards = searchResponse.getSuccessfulShards();

                    if (totalShards != successfulShards) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (ShardSearchFailure failure : searchResponse.getShardFailures()) {
                            stringBuilder.append(failure.reason());
                        }
                        throw new ProductServiceException("Error while retrieving all products" + stringBuilder.toString());
                    }

                    SearchHits hits = searchResponse.getHits();
                    SearchHit[] searchHits = hits.getHits();

                    return Stream.of(searchHits)
                            .map(hit -> {
                                String sourceAsString = hit.getSourceAsString();
                                System.out.println(sourceAsString);
                                Map<String, Object> sourceAsMap = hit.getSourceAsMap();

                                return objectMapper.convertValue(sourceAsMap, Product.class);
                            })
                            .collect(Collectors.toList());
                })
                .doOnError(throwable -> log.error("Error while searchRequest", throwable));

    }


    /**
     * Analyse the response of the
     * @param docWriteResponse
     * @return Boolean true if response has no error
     */
    private Boolean responseAnalyser(DocWriteResponse docWriteResponse) {

        ReplicationResponse.ShardInfo shardInfo = docWriteResponse.getShardInfo();

        if (shardInfo.getFailed() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                stringBuilder.append(failure.reason());
            }
            log.error(stringBuilder.toString());
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}