package com.mobylis.fr.controller;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@RestController
@RequestMapping("/api/private/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Boolean> createProduct(@RequestBody Product productView) {

        return productService.createProduct(productView);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<List<Product>> getProduct(@RequestParam("id") String id) {

        return productService.getProducts();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product product, @RequestParam("id") String id) {

        productService.updateProduct(product, id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@RequestBody String id) {

        productService.deleteProduct(id);
    }

}