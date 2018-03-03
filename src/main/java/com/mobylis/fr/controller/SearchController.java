package com.mobylis.fr.controller;

import com.mobylis.fr.dto.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author ANDRE
 * @since 03/03/2018
 */
@RestController
public class SearchController {

    @GetMapping("/product")
    public Mono<ProductView> getProduct() {
        return null;
    }
}
