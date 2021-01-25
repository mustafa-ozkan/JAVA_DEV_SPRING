package com.cybertek.implementation;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Product> delete(Long id) {
        return null;
    }

    @Override
    public List<Product> updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public List<Product> createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }
}
