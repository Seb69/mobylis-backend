package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * Tester : ElasticSearchCrudRepository
 *
 * @author ANDRE
 * @since 27/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchCrudRepository_EndToEndTest {

    @Autowired
    ElasticSearchRepository elasticSearchRepository;

    @Test
    public void get() throws Exception {

        // BUILD


        // MOCK


        // OPERATE
        elasticSearchRepository.get("qUhC2WEB_Jo6pvCnjl24");


        // CHECK
        Thread.sleep(5000);
    }

    @Test
    public void search_success() {

        final Mono<List<Product>> test = elasticSearchRepository.search("tes");

        Assert.assertNotNull(test.block());
        System.out.println(test.block().toString());
    }
}