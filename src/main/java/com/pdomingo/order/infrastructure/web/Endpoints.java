package com.pdomingo.order.infrastructure.web;

import lombok.RequiredArgsConstructor;

public final class Endpoints {

    public static final String SHOPPING_CART_BASE_PATH = "/shopping_cart";
    public static final String FETCH_SHOPPING_CART = "/{clientId}";
    public static final String MODIFY_SHOPPING_CART = "/{clientId}/product/{productId}";
    public static final String DELETE_SHOPPING_CART = "/{clientId}";
}
