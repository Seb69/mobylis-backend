package com.mobylis.fr.elasticsearch;

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
import reactor.core.publisher.Flux;
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

    public IndexResponse index(IndexRequest indexRequest) throws IOException {

            return client.index(indexRequest);
    }

    public DeleteResponse delete(DeleteRequest deleteRequest) throws IOException {

        return client.delete(deleteRequest);
    }


    public Flux<GetResponse> get(GetRequest getRequest) {

        return Flux.create(sink -> {
            client.getAsync(getRequest, new ActionListener<>() {
                @Override
                public void onResponse(GetResponse getResponse) {
                    sink.next(getResponse);
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


    public Mono<UpdateResponse> update(UpdateRequest updateRequest) {

        return Mono.create(sink -> {
            client.updateAsync(updateRequest, new ActionListener<>() {
                @Override
                public void onResponse(UpdateResponse updateResponse) {
                    sink.success(updateResponse);
                }

                @Override
                public void onFailure(Exception e) {
                    sink.error(e);
                }
            });
        });
    }


}
