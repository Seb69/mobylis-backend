package com.mobylis.fr.controller;

import com.mobylis.fr.domain.Product;
import com.mobylis.fr.service.ProductService;
import com.mobylis.fr.service.exception.CategoryNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author ANDRE
 * @since 25/02/2018
 */
@RequestMapping("/api/product")
@RestController
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) throws CategoryNotFound {

        productService.createProduct(product);
    }


    @PutMapping
    public void updateProduct(@RequestBody Product product) throws CategoryNotFound {

        productService.deleteProduct(product);
    }


    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) throws CategoryNotFound {

        productService.deleteProduct(product);
    }

}