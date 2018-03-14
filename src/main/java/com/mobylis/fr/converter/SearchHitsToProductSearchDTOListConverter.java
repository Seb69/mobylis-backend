package com.mobylis.fr.converter;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductSearchDTO;
import org.elasticsearch.search.SearchHit;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ANDRE
 * @since 28/02/2018
 */
@Component
public class SearchHitsToProductSearchDTOListConverter implements Converter<SearchHit[], List<ProductSearchDTO>> {


    @Override
    public List<ProductSearchDTO> convert(SearchHit[] hits) {

        return Stream.of(hits)
                .map(hit -> {
                    final Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                    ProductSearchDTO productSearchDTO = new ProductSearchDTO();

                    if ((sourceAsMap.get("name") != null)) {
                        productSearchDTO.setName((String) sourceAsMap.get("name"));
                    }
                    if ((sourceAsMap.get("category") != null)) {
                        productSearchDTO.setCategory((String) sourceAsMap.get("category"));
                    }
                    if ((sourceAsMap.get("price") != null)) {
                        productSearchDTO.setPrice(new BigDecimal((String) sourceAsMap.get("price")));
                    }
                    if ((sourceAsMap.get("images") != null)) {
                        productSearchDTO.setImages((List<String>) sourceAsMap.get("images"));
                    }
                    productSearchDTO.setId(hit.getId());
                    return productSearchDTO;
                })
                .collect(Collectors.toList());

    }
}
