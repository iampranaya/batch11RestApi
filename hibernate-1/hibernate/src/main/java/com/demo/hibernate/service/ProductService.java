package com.demo.hibernate.service;

import com.demo.hibernate.dao.ProductDAO;
import com.demo.hibernate.dto.ProductDTO;
import com.demo.hibernate.model.CreateProductRequest;
import com.demo.hibernate.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public Product createProduct(CreateProductRequest createProductRequest) {
        ProductDTO productDTO = productDAO.addProduct(createProductRequest);

        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        return product;
    }

    public List<Product> listProducts() {
        List<ProductDTO> productDTOS = productDAO.listProducts();

        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOS) {
            Product product = new Product();
            product.setProductId(productDTO.getProductId());
            product.setProductName(productDTO.getProductName());
            product.setProductPrice(productDTO.getProductPrice());

            products.add(product);
        }
        return products;
    }
}
