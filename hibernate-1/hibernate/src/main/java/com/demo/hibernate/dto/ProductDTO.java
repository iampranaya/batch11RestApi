package com.demo.hibernate.dto;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "catalog")
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "product_id", length = 256, unique = true)
    public String productId;

    @Column(name = "product_name")
    public String productName;

    @Column(name = "product_price")
    public float productPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
