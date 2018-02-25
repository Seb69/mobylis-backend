package com.mobylis.fr.elasticsearch;

import com.mobylis.fr.domain.Deck;
import com.mobylis.fr.mock.Desk_Mock;
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
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.runner.RunWith;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Tester : Index
 *
 * @author ANDRE
 * @since 18/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ExcludeFromTests
public class Index_EndToEndTest {

    @Autowired
    Index index;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void should_deleteIndex_data() throws Exception {

        // BUILD
        Deck desk = Desk_Mock.createA();
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest();
        deleteIndexRequest.indices("decks");

        // OPERATE
        final Mono<DeleteIndexResponse> indexResponseMono = index.deleteIndex(deleteIndexRequest);

        // CHECK
        indexResponseMono.subscribe(System.out::println);
        Thread.sleep(10000);

    }

    @Test
    public void should_createIndex_data() throws Exception {

        // BUILD
        CreateIndexRequest createIndexRequest = new CreateIndexRequest();
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 0)
        );

        createIndexRequest.index("seats");


        // OPERATE
        CreateIndexResponse indexResponseMono = index.createIndex(createIndexRequest);


    }

    @Test
    public void should_index_data() throws Exception {

        // BUILD
        Deck desk = Desk_Mock.createA();

        IndexRequest indexRequest = new IndexRequest("decks", "doc")
                .source("name", desk.getName(),
                        "brand", desk.getBrand(),
                        "price", desk.getPrice(),
                        "dimension", desk.getDimension(),
                        "description", desk.getDescription());

        // OPERATE
        final Mono<IndexResponse> indexResponseMono = index.index(indexRequest);

        // CHECK
        indexResponseMono.subscribe(indexResponse -> System.out.println(indexResponse.getResult()));
        Thread.sleep(10000);

    }

    @Test
    public void should_delete_data() throws Exception {

        // BUILD
        DeleteRequest deleteRequest = new DeleteRequest("decks", "doc", "QqrmyGEBYcaSTSpZkep-");

        // OPERATE
        final Mono<DeleteResponse> delete = index.delete(deleteRequest);

        // CHECK
        delete.subscribe(indexResponse -> System.out.println(indexResponse.getResult()));
        Thread.sleep(10000);

    }


    @Test
    public void should_update_data() throws Exception {

        // BUILD
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("description", "TEST UPDATE");
        jsonMap.put("name", "TEST NAME UPDATE");
        UpdateRequest updateRequest = new UpdateRequest("decks", "doc", "QarkyGEBYcaSTSpZR-oO").doc(jsonMap);

        // OPERATE
        final Mono<UpdateResponse> update = index.update(updateRequest);

        // CHECK
        update.subscribe(indexResponse -> System.out.println(indexResponse.getResult()));
        Thread.sleep(10000);

    }



    @Test
    public void should_get_data() throws Exception {

        // BUILD
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("description", "TEST UPDATE");
        jsonMap.put("name", "TEST NAME UPDATE");
        GetRequest getRequest = new GetRequest("decks", "doc", "RKoDyWEBYcaSTSpZKeoQ");

        // OPERATE
        final Flux<GetResponse> getResponseFlux = index.get(getRequest);

        // CHECK
        getResponseFlux.subscribe(getResponse -> System.out.println(getResponse.getSourceAsString()));
        Thread.sleep(10000);

    }


    @Test
    public void should_search_data() throws Exception {

        // BUILD
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("price", "570"));
        sourceBuilder.size(1);
        sourceBuilder.timeout(new TimeValue(1, TimeUnit.SECONDS));
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(sourceBuilder);

        // OPERATE
        final Mono<SearchResponse> getResponseFlux = index.search(searchRequest);

        // CHECK
        getResponseFlux.subscribe(getResponse -> System.out.println(getResponse.getHits().totalHits));
        Thread.sleep(10000);

    }



}
    