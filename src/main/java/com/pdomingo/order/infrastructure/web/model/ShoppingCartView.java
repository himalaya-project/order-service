package com.pdomingo.order.infrastructure.web.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@Data
@RequiredArgsConstructor
public class ShoppingCartView {

    private static final ShoppingCartView EMPTY_CART = new ShoppingCartView(Collections.emptyList());

    private final Collection<String> productIds;

    public static ShoppingCartView empty() {
        return EMPTY_CART;
    }
}
