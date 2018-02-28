package com.mobylis.fr.converter;

import com.mobylis.fr.dto.ProductSearchDTO;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

/**
 * Tester : ProductMapToProductSearchDTO
 *
 * @author ANDRE
 * @since 28/02/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapToProductSearchDTO_Test {

//    @Qualifier("mvcConversionService")
    @Autowired
    ConversionService conversionService;


    @Test
    public void convert() throws Exception {

        // BUILD
        Map<Object, String> map = new HashMap<>();
        map.put("name", "test");
        map.put("description", "test");
        map.put("brand", "test");
        map.put("price", "test");
        map.put("category", "test");
        map.put("dimension", "test");


        // MOCK


        // OPERATE
        final ProductSearchDTO convert = conversionService.convert(map, ProductSearchDTO.class);

        // CHECK
        System.out.println(convert);


    }
}
    