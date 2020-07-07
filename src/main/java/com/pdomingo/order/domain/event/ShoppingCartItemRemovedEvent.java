package com.pdomingo.order.domain.event;

import com.pdomingo.kernel.core.ddd.BaseDomainEvent;
import com.pdomingo.kernel.event.shoppingcart.ShoppingCartItemAdded;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.model.ids.ShoppingCartId;

import java.time.Instant;

public class ShoppingCartItemRemovedEvent extends BaseDomainEvent<ShoppingCartId> {

    private final ClientId clientId;
    private final ProductId productId;

    public ShoppingCartItemRemovedEvent(ShoppingCartId shoppingCartId, ClientId clientId, ProductId productId) {
        super(shoppingCartId, Instant.now());
        this.clientId = clientId;
        this.productId = productId;
        this.timestamp = Instant.now();
    }

    public ClientId clientId() {
        return clientId;
    }

    public ProductId productId() {
        return productId;
    }
}
