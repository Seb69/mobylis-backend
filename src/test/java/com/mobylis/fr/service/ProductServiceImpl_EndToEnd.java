package com.mobylis.fr.service;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.mock.Product_Mock;
import com.mobylis.fr.service.product.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

/**
 * Tester : ProductServiceImpl
 *
 * @author ANDRE
 * @since 25/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local-swarm")
@TestPropertySource("classpath:env.yml")
public class ProductServiceImpl_EndToEnd {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @Test
    public void createProduct_success() throws Exception {

        // BUILD
        Product product = Product_Mock.createA();

        // OPERATE
        Mono<Boolean> product1 = productServiceImpl.createProduct(product);

        // CHECK
        StepVerifier.create(product1)
                .consumeNextWith(System.out::println)
                .verifyComplete();

    }


    @Test
    public void createProduct_failed() throws Exception {

        // BUILD
        Product product = Product_Mock.createA();

        // OPERATE
        Mono<Boolean> product1 = productServiceImpl.createProduct(product);

        // CHECK
        StepVerifier.create(product1)
                .consumeNextWith(System.out::println)
                .verifyComplete();

    }

    //    @Test(expected = ProductServiceException.class)
//    public void createProduct_elasticsearch_throw_runtimeException() throws Exception {
//
//        // BUILD
//        Product product = Product_Mock.createA();
//
//        // MOCK
//        Mockito.when(elasticSearchRepository.save(ArgumentMatchers.any(Product.class))).thenThrow(new IllegalArgumentException());
//
//        // OPERATE
//        productServiceImpl.createProduct(product);
//
//    }
//
//    @Test(expected = ProductServiceException.class)
//    public void createProduct_mysql_throw_runtimeException() throws Exception {
//
//        // BUILD
//        Product product = Product_Mock.createA();
//
//        // MOCK
//        Mockito.when(elasticSearchRepository.save(ArgumentMatchers.any(Product.class))).thenReturn("bjeze");
//
//        // OPERATE
//        productServiceImpl.createProduct(product);
//
//    }
//
    @Test
    public void deleteProduct() throws Exception {

        // BUILD
        String productId = "uF1CwWMBsu0ED7OeB2Op";

        // OPERATE
        Mono<Boolean> booleanMono = productServiceImpl.deleteProduct(productId);

        StepVerifier.create(booleanMono)
                .expectNext(Boolean.TRUE)
                .verifyComplete();

    }


    @Test
    public void updateProduct() throws Exception {

        // BUILD
        String productId = "sl3rwGMBsu0ED7OeWmNa";
        Product product = Product_Mock.createA();

        // OPERATE
        Mono<Boolean> booleanMono = productServiceImpl.updateProduct(product, productId);

        StepVerifier.create(booleanMono)
                .expectNext(Boolean.TRUE)
                .verifyComplete();

    }


    @Test
    public void getProducts() throws Exception {


        // OPERATE
        Mono<List<Product>> booleanMono = productServiceImpl.getProducts();

        StepVerifier.create(booleanMono)
                .consumeNextWith(list -> System.out.println(list.toString()))
                .verifyComplete();

    }
//
//
//    @Test
//    public void deleteProduct_elasticsearch_throw_runtimeException() throws Exception {
//
//        // BUILD
//        String productId = "dqdfsdf";
//
//        // MOCK
//        Mockito.doThrow(new ElasticSearchException("Test exception")).when(elasticSearchRepository).delete(ArgumentMatchers.anyString());
//
//        // OPERATE
//        productServiceImpl.deleteProduct(productId);
//
//    }
}
