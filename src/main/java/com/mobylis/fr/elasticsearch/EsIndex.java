package com.mobylis.fr.elasticsearch;

import com.mobylis.fr.service.exception.ElasticSearchException;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * This class has 2 responsabiliries
 * - handle low level call (synchrone and asynchronous)
 * - handle low level errors
 *
 * @author ANDRE
 * @since 18/02/2018
 */
@Component
public class EsIndex {

    private RestHighLevelClient client;

    @Autowired
    public EsIndex(RestHighLevelClient client) {
        this.client = client;
    }

    public CreateIndexResponse createIndex(CreateIndexRequest createIndexRequest) {

        try {
            return client.indices().create(createIndexRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to create index: " + createIndexRequest.getDescription(), e);
        }
    }

    public DeleteIndexResponse deleteIndex(DeleteIndexRequest deleteIndexRequest) {

        try {
            return client.indices().delete(deleteIndexRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to delete index: " + deleteIndexRequest.getDescription(), e);
        }
    }

    public IndexResponse index(IndexRequest indexRequest) {

        try {
            return client.index(indexRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to index document: " + indexRequest.getDescription(), e);
        }
    }

    public DeleteResponse delete(DeleteRequest deleteRequest) {

        try {
            return client.delete(deleteRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to delete document: " + deleteRequest.getDescription(), e);
        }
    }

    public UpdateResponse update(UpdateRequest updateRequest) {

        try {
            return client.update(updateRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to update document: " + updateRequest.getDescription(), e);
        }
    }

    public Mono<GetResponse> get(GetRequest getRequest) {

        return Mono.create(sink ->
            client.getAsync(getRequest, new ActionListener<>() {
                @Override
                public void onResponse(GetResponse getResponse) {
                    sink.success(getResponse);
                }

                @Override
                public void onFailure(Exception e) {
                    sink.error(e);
                }
            })
        );
    }

    public Mono<SearchResponse> search(SearchRequest searchRequest) {

        return Mono.create(sink ->
            client.searchAsync(searchRequest, new ActionListener<>() {

                @Override
                public void onResponse(SearchResponse searchResponse) {
                    sink.success(searchResponse);
                }

                @Override
                public void onFailure(Exception e) {
                    sink.error(e);
                }
            })
        );
    }

}