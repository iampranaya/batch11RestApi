package com.demo.hibernate.controller;

import com.demo.hibernate.model.CreateProductRequest;
import com.demo.hibernate.model.Product;
import com.demo.hibernate.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/v1/api/product")
    public ResponseEntity<Product> addProduct(@RequestBody CreateProductRequest createProductRequest) {
        Product product = productService.createProduct(createProductRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/api/product")
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productService.listProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
