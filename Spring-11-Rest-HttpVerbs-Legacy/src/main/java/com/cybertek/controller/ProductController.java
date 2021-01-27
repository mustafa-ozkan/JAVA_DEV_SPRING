package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //using legacy requestmapping and value is my endpoint method shos what we want
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products")
    public @ResponseBody
    List<Product> getProducts(){
        return productService.getProducts();
    }

    //CREATE PRODUCT

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody List<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    //DELETE PRODUCT

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody List<Product> deleteProduct(@PathVariable("id") Long id){
        return productService.delete(id);
    }
    //UPDATE PRODUCT -@RequestBody

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody List<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

}
