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

    public CreateIndexResponse createIndex(CreateIndexRequest createIndexRequest) throws IOException {

        return client.indices().create(createIndexRequest);
    }

    public DeleteIndexResponse deleteIndex(DeleteIndexRequest deleteIndexRequest) throws IOException {

        return client.indices().delete(deleteIndexRequest);
    }

    public IndexResponse index(IndexRequest indexRequest) {

        try {
            return client.index(indexRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to index: " + indexRequest.sourceAsMap().toString());
        }
    }

    public DeleteResponse delete(DeleteRequest deleteRequest) {

        try {
            return client.delete(deleteRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to index: " + deleteRequest.toString());
        }
    }


    public UpdateResponse update(UpdateRequest updateRequest) {

        try {
            return client.update(updateRequest);
        } catch (IOException e) {
            throw new ElasticSearchException("Fail to update: " + updateRequest.toString());
        }
    }


    public Mono<GetResponse> get(GetRequest getRequest) {

        return Mono.create(sink -> {
            client.getAsync(getRequest, new ActionListener<>() {
                @Override
                public void onResponse(GetResponse getResponse) {
                    sink.success(getResponse);
                }

                @Override
                public void onFailure(Exception e) {
                    sink.error(e);
                }
            });
        });
    }

    public Mono<SearchResponse> search(SearchRequest searchRequest) {

        return Mono.create(sink -> {
            client.searchAsync(searchRequest, new ActionListener<>() {

                @Override
                public void onResponse(SearchResponse searchResponse) {
                    sink.success(searchResponse);
                }

                @Override
                public void onFailure(Exception e) {
                    sink.error(e);
                }
            });
        });
    }


}
