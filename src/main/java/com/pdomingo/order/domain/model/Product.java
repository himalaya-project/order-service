package com.pdomingo.order.domain.model;

import com.pdomingo.order.domain.model.ids.ProductId;

import javax.money.MonetaryAmount;

public class Product {

    private final ProductId productId;
    private final MonetaryAmount price;

    public Product(ProductId productId, MonetaryAmount price) {
        this.productId = productId;
        this.price = price;
    }

    public MonetaryAmount price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }

    public ProductId id() {
        return productId;
    }
}
