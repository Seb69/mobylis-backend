package com.mobylis.fr.converter;

import com.mobylis.fr.dto.ProductView;
import com.mobylis.fr.mock.Map_Mock;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

/**
 * Tester : MapToProductViewConverter
 *
 * @author ANDRE
 * @since 03/03/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class MapToProductViewConverter_UnitTest {

    @InjectMocks
    MapToProductViewConverter mapToProductViewConverter = new MapToProductViewConverter();


    @Test
    public void convert() throws Exception {

        // BUILD
        final Map<String, Object> stringObjectMap = Map_Mock.create();

        // OPERATE
        final ProductView convert = mapToProductViewConverter.convert(stringObjectMap);

        // CHECK
        Assert.assertNotNull(convert);
    }
}
