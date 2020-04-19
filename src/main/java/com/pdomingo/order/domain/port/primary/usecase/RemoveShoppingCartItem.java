package com.pdomingo.order.domain.port.primary.usecase;

import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;

import java.util.Collection;

public interface RemoveShoppingCartItem {
    ShoppingCartView remove(ClientId clientId, ProductId productId);
}
