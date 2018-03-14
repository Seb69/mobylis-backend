package com.mobylis.fr.converter;

import com.mobylis.fr.dto.ProductCreationDTO;
import com.mobylis.fr.mock.Map_Mock;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.junit.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

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
        final ProductCreationDTO convert = mapToProductViewConverter.convert(stringObjectMap);

        // CHECK
        Assert.assertNotNull(convert);
    }
}
