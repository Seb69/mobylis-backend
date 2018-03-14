package com.mobylis.fr.repository;

import com.mobylis.fr.domain.ProductEs;
import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductSearchDTO;
import com.mobylis.fr.elasticsearch.EsIndex;
import com.mobylis.fr.repository.exception.ElasticSearchRepositoryException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * This has 2 responsibilities
 * - create elasticsearch request object
 * - convert response object into exploitable object
 *
 * @author ANDRE
 * @since 25/02/2018
 */
@Service
public class ElasticSearchRepository {

    private EsIndex esIndex;
    private ConversionService conversionService;

    // Index
    private final static String INDEX_NAME = "products";
    private final static String INDEX_TYPE = "doc";

    // Fields
    private final static String FIELD_NAME = "name";
    private final static String FIELD_DESCRIPTION = "description";
    private final static String FIELD_BRAND = "brand";
    private final static String FIELD_IMAGES = "images";
    private final static String FIELD_PRICE = "price";
    private final static String FIELD_CATEGORY = "category";
    private final static String FIELD_SUBCATEGORY = "subCategory";
    private final static String FIELD_DIMENSION = "dimension";

    @Autowired
    public ElasticSearchRepository(EsIndex esIndex, ConversionService conversionService) {
        this.esIndex = esIndex;
        this.conversionService = conversionService;
    }

    public String save(ProductEs productEs) {

        IndexRequest indexRequest = new IndexRequest(INDEX_NAME, INDEX_TYPE)
                .source(FIELD_NAME, productEs.getName(),
                        FIELD_DESCRIPTION, productEs.getDescription(),
                        FIELD_BRAND, productEs.getBrand(),
                        FIELD_IMAGES, productEs.getImages(),
                        FIELD_PRICE, productEs.getPrice(),
                        FIELD_CATEGORY, productEs.getCategory(),
                        FIELD_SUBCATEGORY, productEs.getSubCategory(),
                        FIELD_DIMENSION, productEs.getDimension());

        // Save in elasticSearch
        final IndexResponse index = esIndex.index(indexRequest);

        //  Checkout the indexResponse status
        if (index.getResult() != DocWriteResponse.Result.CREATED)
            throw new ElasticSearchRepositoryException("Product is not properly index: " + productEs.toString());

        // Set ElasticSearch ID
        return index.getId();
    }

    public void delete(String id) {
        DeleteRequest deleteRequest = new DeleteRequest(INDEX_NAME, INDEX_TYPE, id);

        final DeleteResponse delete = esIndex.delete(deleteRequest);

        if (delete.getResult() != DocWriteResponse.Result.DELETED)
            throw new ElasticSearchRepositoryException("Product is not properly deleted with id: " + id);
    }

    public ProductEs update(ProductEs product, String id) {

        UpdateRequest updateRequest = new UpdateRequest(INDEX_NAME, INDEX_TYPE, id)
                .doc(FIELD_NAME, product.getName(),
                        FIELD_DESCRIPTION, product.getDescription(),
                        FIELD_BRAND, product.getBrand(),
                        FIELD_PRICE, product.getPrice(),
                        FIELD_IMAGES, product.getImages(),
                        FIELD_CATEGORY, product.getCategory(),
                        FIELD_SUBCATEGORY, product.getSubCategory(),
                        FIELD_DIMENSION, product.getDimension());

        final UpdateResponse update = esIndex.update(updateRequest);

        if (update.getResult() != DocWriteResponse.Result.UPDATED) {
            throw new ElasticSearchRepositoryException("Product is not properly deleted with id: ");
        }

        // Get result source map
        final Map<String, Object> source = update.getGetResult().getSource();

        return conversionService.convert(source, ProductEs.class);
    }

    public Mono<ProductSearchDTO> get(String id) {

        GetRequest getRequest = new GetRequest(INDEX_NAME, INDEX_TYPE, id);

        final Mono<GetResponse> getResponseMono = esIndex.get(getRequest);

        return getResponseMono
                .map(getRequestMono -> conversionService.convert(getRequestMono.getSourceAsMap(), ProductSearchDTO.class));
    }

    public Mono<List<ProductSearchDTO>> search(String searchText) {

        // Create search request on index only
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);

        // Fine tune the search
        MultiMatchQueryBuilder multiMatchQueryBuilder = new MultiMatchQueryBuilder(searchText);
        multiMatchQueryBuilder
                .field(FIELD_DESCRIPTION, 1)
                .field(FIELD_NAME, 2)
                .fuzziness(Fuzziness.AUTO);

        // Search details
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(multiMatchQueryBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(10);
        String[] includeFields = new String[]{FIELD_NAME, FIELD_PRICE, FIELD_IMAGES, FIELD_CATEGORY};
        String[] excludeFields = new String[]{FIELD_DESCRIPTION, FIELD_BRAND};
        sourceBuilder.fetchSource(includeFields, excludeFields);

        searchRequest.source(sourceBuilder);

        final Mono<SearchResponse> searchResponseMono = esIndex.search(searchRequest);

        // Convert SerachResponse to List
        return searchResponseMono
                .map(searchResponse -> {
                    final SearchHit[] hits = searchResponse.getHits().getHits();
                    return conversionService.convert(hits, List.class);
                });
    }

}