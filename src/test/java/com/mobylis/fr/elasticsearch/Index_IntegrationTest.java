//package com.mobylis.fr.elasticsearch;
//
//import com.mobylis.fr.domain.Deck;
//import org.elasticsearch.action.delete.DeleteRequest;
//import org.elasticsearch.action.delete.DeleteResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import reactor.core.publisher.Mono;
//
//import java.math.BigDecimal;
//
///**
// * Tester : Index
// *
// * @author ANDRE
// * @since 18/02/2018
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class Index_IntegrationTest {
//
//    @Autowired
//    Index index;
//
//
//    @MockBean
//    RestHighLevelClient restHighLevelClient;
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @Test
//    public void should_index_data() throws Exception {
//
//        // BUILD
//        Deck desk = new Deck();
//
//        desk.setName("6 Bureau Open Space");
//        desk.setBrand("6 MOBEL LINEA");
//        desk.setDescription("6 Mobilier très robuste et comfortable.");
//        desk.setPrice(BigDecimal.valueOf(570L));
//
//        IndexRequest indexRequest = new IndexRequest("decks", "doc")
//                .source("name", desk.getName(),
//                        "brand", desk.getBrand(),
//                        "price", desk.getPrice(),
//                        "dimension", desk.getDimension(),
//                        "description", desk.getDescription());
//
//        // OPERATE
//        final Mono<IndexResponse> indexResponseMono = index.index(indexRequest);
//
//        // CHECK
//        indexResponseMono.subscribe(indexResponse -> System.out.println(indexResponse.getResult()));
//        Thread.sleep(10000);
//
//    }
//
//    @Test
//    public void should_delete_data() throws Exception {
//
//        // BUILD
//        DeleteRequest deleteRequest = new DeleteRequest("decks", "doc", "QqrmyGEBYcaSTSpZkep-");
//
//        // OPERATE
//        final Mono<DeleteResponse> delete = index.delete(deleteRequest);
//
//        // CHECK
//        delete.subscribe(indexResponse -> System.out.println(indexResponse.getResult()));
//        Thread.sleep(10000);
//
//    }
//
//
//}
//