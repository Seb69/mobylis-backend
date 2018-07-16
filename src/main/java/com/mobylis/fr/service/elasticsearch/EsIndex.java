package com.mobylis.fr.service.elasticsearch;

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
import reactor.core.publisher.Mono;

/**
 * Low level class that make asynchronous call to ElasticSearch
 */
public interface EsIndex {

  String test = "test";

  Mono<CreateIndexResponse> createIndex(CreateIndexRequest createIndexRequest);

  Mono<DeleteIndexResponse> deleteIndex(DeleteIndexRequest deleteIndexRequest);

  Mono<IndexResponse> index(IndexRequest indexRequest);

  Mono<DeleteResponse> delete(DeleteRequest deleteRequest);

  Mono<UpdateResponse> update(UpdateRequest updateRequest);

  Mono<GetResponse> get(GetRequest getRequest);

  Mono<SearchResponse> search(SearchRequest searchRequest);
}
