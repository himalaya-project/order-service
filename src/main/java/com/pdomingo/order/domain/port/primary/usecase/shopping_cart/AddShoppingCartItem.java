package com.pdomingo.order.domain.port.primary.usecase.shopping_cart;

import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;

public interface AddShoppingCartItem {
    ShoppingCartView add(ClientId clientId, ProductId productId);
}
