package com.mobylis.fr.controller;

import com.mobylis.fr.dto.ProductCreationDTO;
import com.mobylis.fr.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public ProductCreationDTO createProduct(@RequestBody ProductCreationDTO productView) {

        return productService.createProduct(productView);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreationDTO getProduct(@RequestParam("id") Long id) {

        return productService.getProduct(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody ProductCreationDTO product) {

        productService.updateProduct(product);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteProduct(@RequestBody Long id) {

        productService.deleteProduct(id);
    }

}