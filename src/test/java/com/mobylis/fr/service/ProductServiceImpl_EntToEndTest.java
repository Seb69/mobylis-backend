package com.mobylis.fr.service;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.mock.Product_Mock;
import org.junit.runner.RunWith;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Tester : ProductServiceImpl
 *
 * @author ANDRE
 * @since 25/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImpl_EntToEndTest {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @Test
    public void createProduct() throws Exception {

        // BUILD
        Product product = Product_Mock.createA();


        // MOCK


        // OPERATE
        productServiceImpl.createProduct(product);

        // CHECK


    }
}
    