package com.demo.hibernate.dao;

import com.demo.hibernate.dto.ProductDTO;
import com.demo.hibernate.model.CreateProductRequest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ProductDTO addProduct(CreateProductRequest createProductRequest) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(UUID.randomUUID().toString());
        productDTO.setProductName(createProductRequest.getProductName());
        productDTO.setProductPrice(createProductRequest.getProductPrice());

        sessionFactory.getCurrentSession().save(productDTO);
        return productDTO;
    }

    public List<ProductDTO> listProducts() {
        return sessionFactory.getCurrentSession().createQuery("FROM ProductDTO").getResultList();
    }
}
