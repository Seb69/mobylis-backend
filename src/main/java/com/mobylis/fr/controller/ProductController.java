package com.mobylis.fr.controller;

import com.mobylis.fr.domain.ProductMysql;
import com.mobylis.fr.dto.ProductView;
import com.mobylis.fr.repository.ElasticSearchRepository;
import com.mobylis.fr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@RestController
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/api/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductMysql createProduct(@RequestBody ProductView productView) {

        return productService.createProduct(productView);
    }

    @GetMapping(value = "/api/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductMysql getProduct(@RequestParam("id") Long id) {

        return productService.getProduct(id);
    }

    @PutMapping(value = "/api/product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody ProductMysql product) {

        productService.updateProduct(product);
    }

    @DeleteMapping(value = "/api/product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@RequestBody Long id) {

        productService.deleteProduct(id);
    }

}