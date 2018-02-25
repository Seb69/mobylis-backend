package com.mobylis.fr.repository;

import com.mobylis.fr.domain.AbstractProduct;
import com.mobylis.fr.domain.Deck;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
@Repository
public class SuperObjectRepository {

    private DeskRepository deskRepository;

    private RestHighLevelClient client;

    @Autowired
    public SuperObjectRepository(DeskRepository deskRepository, RestHighLevelClient client) {
        this.deskRepository = deskRepository;
        this.client = client;
    }

    public <T extends AbstractProduct> T save(T object) {
        Deck desk = new Deck();

        desk.setName("Bureau Open Space");
        desk.setBrand("MOBEL LINEA");
        desk.setDescription("Mobilier très robuste et comfortable.");
        desk.setPrice(BigDecimal.valueOf(570L));

//        IndexRequest indexRequest = new IndexRequest("decks", "doc", "1")
//                .source("name", desk.getName(),
//                        "brand", desk.getBrand(),
//                        "price", desk.getPrice(),
//                        "dimension", desk.getDimension(),
//                        "description", desk.getDescription());
//
//        try {
//            IndexResponse indexResponse = client.index(indexRequest);
//        } catch (IOException e) {
//        }

        CreateIndexRequest request = new CreateIndexRequest("decks");

        return null;
    }

}
