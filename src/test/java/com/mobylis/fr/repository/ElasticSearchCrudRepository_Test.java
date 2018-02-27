package com.mobylis.fr.repository;

import com.mobylis.fr.domain.Product;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

/**
 * Tester : ElasticSearchCrudRepository
 *
 * @author ANDRE
 * @since 27/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchCrudRepository_Test {

    @Autowired
    ElasticSearchCrudRepository elasticSearchCrudRepository;


    @Test
    public void get() throws Exception {

        // BUILD


        // MOCK


        // OPERATE
        final Product product = elasticSearchCrudRepository.get("m0hc2GEB_Jo6pvCnTV3Y");


        // CHECK
        Thread.sleep(10000);


    }
}
    