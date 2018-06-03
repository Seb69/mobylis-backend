package com.mobylis.fr.controller;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.repository.ElasticSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
@RestController
@RequestMapping("/api/public/product")
public class SearchController {

    private ElasticSearchRepository elasticSearchRepository;

    @Autowired
    public SearchController(ElasticSearchRepository elasticSearchRepository) {
        this.elasticSearchRepository = elasticSearchRepository;
    }

    @GetMapping(value = "/search")
    public Mono<List<Product>> searchProduct(@RequestParam("search") String search) {
        return elasticSearchRepository.search(search);
    }

    @GetMapping(value = "/search/category")
    public Mono<List<Product>> searchCategory(@RequestParam("search") String category) {
        return elasticSearchRepository.searchCategory(category);
    }

    @GetMapping
    public Mono<Product> getProduct(@RequestParam("id") String id) {
        return elasticSearchRepository.get(id);
    }

}
