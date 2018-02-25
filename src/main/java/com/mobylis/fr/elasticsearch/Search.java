package com.mobylis.fr.elasticsearch;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author ANDRE
 * @since 24/02/2018
 */
@Component
public class Search {

//    public Mono<SearchResponse> search(SearchRequest searchRequest) {
//
//        return Mono.create(sink -> {
//            client.searchAsync(searchRequest, new ActionListener<>() {
//
//                @Override
//                public void onResponse(SearchResponse searchResponse) {
//                    sink.success(searchResponse);
//                }
//
//                @Override
//                public void onFailure(Exception e) {
//                    sink.error(e);
//                }
//            });
//        });
//    }

}
