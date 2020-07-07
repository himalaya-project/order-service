package com.pdomingo.order.domain.event.outgoing;

import com.pdomingo.kernel.event.shoppingcart.ShoppingCartItemAdded;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.model.ids.ShoppingCartId;

public class ShoppingCartItemRemovedEvent extends ShoppingCartItemAdded<ShoppingCartId> {
    public ShoppingCartItemRemovedEvent(ShoppingCartId sourceId, ClientId clientId, ProductId productId) {
        super(sourceId, clientId, productId);
    }
}
