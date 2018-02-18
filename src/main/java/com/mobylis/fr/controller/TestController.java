package com.mobylis.fr.controller;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ANDRE
 * @since 03/12/2017
 */
@RestController
public class TestController {

    private RestHighLevelClient client;

    public TestController(RestHighLevelClient client) {
        this.client = client;
    }

    @GetMapping("test")
    public IndexResponse test() throws IOException {

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimc hsd qsdy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out qsdq");
        jsonMap.put("name", "test");
        IndexRequest indexRequest = new IndexRequest("posts", "doc", "3")
                .source(jsonMap);

        return client.index(indexRequest);
    }


    @GetMapping("all")
    public SearchResponse all() throws IOException {

        GetRequest getRequest = new GetRequest(
                "posts",
                "doc",
                "1");

        SearchRequest searchRequest = new SearchRequest("posts");
        searchRequest.types("doc");

        return client.search(searchRequest);
    }

}
