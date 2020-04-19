package com.pdomingo.order.domain.port.primary.usecase;

import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;

public interface FetchShoppingCart {
    ShoppingCartView fetch(ClientId clientId);
}
