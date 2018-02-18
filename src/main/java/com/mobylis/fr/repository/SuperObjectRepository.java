package com.mobylis.fr.repository;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ANDRE
 * @since 18/02/2018
 */
public class SuperObjectRepository {

    private DeskRepository deskRepository;

    private RestHighLevelClient client;

    @Autowired
    public SuperObjectRepository(DeskRepository deskRepository, RestHighLevelClient client) {
        this.deskRepository = deskRepository;
        this.client = client;
    }

    public Object save(Object object) {


        return null;
    }

}
