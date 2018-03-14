package com.mobylis.fr.controller;

import com.mobylis.fr.service.ProductService;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

/**
 * Tester : ProductController
 *
 * @author ANDRE
 * @since 04/03/2018
 */
@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
public class ProductController_Test {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ProductService productService;

    @Test
    public void hello() throws Exception {

        // BUILD


        // MOCK


        // OPERATE
        webClient.get()
                .uri("/api/private/hello")
                .accept(MediaType.ALL)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hello");


        // CHECK


    }
}
    