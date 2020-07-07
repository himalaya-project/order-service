package com.pdomingo.order.domain.event.outgoing;

import com.pdomingo.kernel.core.ddd.BaseDomainEvent;
import com.pdomingo.kernel.core.ddd.DomainEvent;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.model.ids.ShoppingCartId;

import java.time.Instant;

public class ShoppingCartItemAddedEvent extends BaseDomainEvent<ShoppingCartId> {

    private final ClientId clientId;
    private final ProductId productId;

    public ShoppingCartItemAddedEvent(ShoppingCartId shoppingCartId, ClientId clientId, ProductId productId) {
        super(shoppingCartId, Instant.now());
        this.clientId = clientId;
        this.productId = productId;
        this.timestamp = Instant.now();
    }
}
