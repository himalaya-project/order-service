package com.pdomingo.order.domain.port.primary.usecase.shopping_cart;

import com.pdomingo.order.domain.model.ids.ClientId;

public interface DeleteShoppingCart {
    void delete(ClientId clientId);
}
