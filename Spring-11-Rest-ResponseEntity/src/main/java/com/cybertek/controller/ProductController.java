package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //using legacy requestmapping and value is my endpoint method shos what we want
    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") Long id) {

        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    //CREATE PRODUCT

    @PostMapping
    public List<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    //DELETE PRODUCT

    @DeleteMapping(value = "/{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        return productService.delete(id);
    }
    //UPDATE PRODUCT -@RequestBody

    @PutMapping(value = "/{id}")
    public List<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

}
