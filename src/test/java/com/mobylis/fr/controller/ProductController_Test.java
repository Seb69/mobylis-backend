package com.mobylis.fr.controller;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.service.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

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
        String esId = "dqsdqs";


        // MOCK
        Product productCreationDTO = new Product();
        productCreationDTO.setBrand("TEST");
        List<Product> productCreationDTO1 = List.of(productCreationDTO);
        Mono<List<Product>> listMono = Mono.justOrEmpty(productCreationDTO1);
        Mockito.when(productService.getProducts()).thenReturn(listMono);


        // OPERATE
        webClient.get()
                .uri("/api/private/product?id=test")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(List.class);


        // CHECK


    }
}
    