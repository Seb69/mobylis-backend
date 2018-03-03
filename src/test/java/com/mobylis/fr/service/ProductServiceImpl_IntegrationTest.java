package com.mobylis.fr.service;

import com.mobylis.fr.configuration.TestConfiguration;
import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;
import com.mobylis.fr.mock.ProductCreationDTO_Mock;
import com.mobylis.fr.mock.Product_Mock;
import com.mobylis.fr.repository.ElasticSearchRepository;
import com.mobylis.fr.repository.MysqlRepository;
import com.mobylis.fr.service.exception.ElasticSearchException;
import com.mobylis.fr.service.exception.ProductServiceException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tester : ProductServiceImpl
 *
 * @author ANDRE
 * @since 25/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestConfiguration
public class ProductServiceImpl_IntegrationTest {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @MockBean
    MysqlRepository mysqlRepository;

    @MockBean
    ElasticSearchRepository elasticSearchRepository;

    @Test
    public void createProduct_success() throws Exception {

        // BUILD
        ProductView product = ProductCreationDTO_Mock.createA();

        // MOCK
        Mockito.when(elasticSearchRepository.save(ArgumentMatchers.any(ProductEs.class))).thenReturn("JVGHJD");
        Mockito.when(mysqlRepository.save(ArgumentMatchers.any(ProductMysql.class))).thenReturn(Product_Mock.createA());

        // OPERATE
        final ProductMysql savedProduct = productServiceImpl.createProduct(product);

        // CHECK
        Assert.assertNotNull(savedProduct);

    }

    @Test(expected = ProductServiceException.class)
    public void createProduct_elasticsearch_throw_runtimeException() throws Exception {

        // BUILD
        ProductView product = ProductCreationDTO_Mock.createA();

        // MOCK
        Mockito.when(elasticSearchRepository.save(ArgumentMatchers.any(ProductEs.class))).thenThrow(new IllegalArgumentException());

        // OPERATE
        productServiceImpl.createProduct(product);

    }

    @Test(expected = ProductServiceException.class)
    public void createProduct_mysql_throw_runtimeException() throws Exception {

        // BUILD
        ProductView product = ProductCreationDTO_Mock.createA();

        // MOCK
        Mockito.when(elasticSearchRepository.save(ArgumentMatchers.any(ProductEs.class))).thenReturn("bjeze");
        Mockito.when(mysqlRepository.save(ArgumentMatchers.any(ProductMysql.class))).thenThrow(new IllegalArgumentException());

        // OPERATE
        productServiceImpl.createProduct(product);

    }

    @Test
    public void deleteProduct() throws Exception {

        // BUILD
        Long productId = 1L;

        // MOCK
        Mockito.when(mysqlRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Product_Mock.createA());
        Mockito.doNothing().when(mysqlRepository).delete(ArgumentMatchers.anyLong());
        Mockito.doNothing().when(elasticSearchRepository).delete(ArgumentMatchers.anyString());

        // OPERATE
        productServiceImpl.deleteProduct(productId);

    }


    @Test
    public void deleteProduct_elasticsearch_throw_runtimeException() throws Exception {

        // BUILD
        Long productId = 1L;

        // MOCK
        Mockito.when(mysqlRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Product_Mock.createA());
        Mockito.doThrow(new ElasticSearchException("Test exception")).when(elasticSearchRepository).delete(ArgumentMatchers.anyString());
        Mockito.doThrow(new ElasticSearchException("Test exception")).when(mysqlRepository).delete(ArgumentMatchers.anyLong());

        // OPERATE
        productServiceImpl.deleteProduct(productId);

    }
}
    