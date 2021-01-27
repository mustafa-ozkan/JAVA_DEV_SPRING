package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //to not send api empty good practice is to use ResponseEntity
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {

        HttpHeaders responseHttpHeaders = new HttpHeaders();

        responseHttpHeaders.set("Version", "Cybertek.V1");
        responseHttpHeaders.set("Operation", "Get List");

        return ResponseEntity
                .ok() //wheneever we call this entity status will be 200
                .headers(responseHttpHeaders)//whatever we created here
                .body(productService.getProducts());
    }

    //CREATE PRODUCT

    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product) {


        List<Product> set = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "Cybertek.V1")
                .header("Operation", "Create Product")
                .body(set);
    }
    //DELETE PRODUCT

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Long id) {

        HttpHeaders responseHttpHeaders = new HttpHeaders();

        responseHttpHeaders.set("Version", "Cybertek.V1");
        responseHttpHeaders.set("Operation", "Delete");

        List<Product> productList = productService.delete(id);


        return new ResponseEntity<>(productList, responseHttpHeaders, HttpStatus.OK);
    }
    //UPDATE PRODUCT -@RequestBody

    @PutMapping(value = "/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "Cybertek.V1");
        map.add("Operation", "Update");

        List<Product> productList = productService.updateProduct(id, product);


        return new ResponseEntity<>(productList, map, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts() {
        return ResponseEntity
                .ok(new ResponseWrapper("Products succesfully retrieved", productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> delete2Product(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new ResponseWrapper("Product successfully deleted"));
    }

}
