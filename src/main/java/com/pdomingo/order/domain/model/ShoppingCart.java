package com.pdomingo.order.domain.model;

import com.pdoming.kernel.core.ddd.AggregateRoot;
import com.pdomingo.order.domain.event.outgoing.ShoppingCartItemAddedEvent;
import com.pdomingo.order.domain.event.outgoing.ShoppingCartItemRemovedEvent;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.model.ids.ShoppingCartId;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ShoppingCart extends AggregateRoot<ShoppingCartId> {

    private final ShoppingCartId shoppingCartId;
    private final ClientId clientId;

    private Collection<ProductId> cart;

    // TODO hide this variable and store only in database
    private Instant expirationDate;

    public ShoppingCart(ShoppingCartId shoppingCartId, ClientId clientId, Collection<ProductId> cart) {
        this.shoppingCartId = Objects.requireNonNull(shoppingCartId);
        this.clientId = Objects.requireNonNull(clientId);
        this.cart = cart;
    }

    public ShoppingCart(ShoppingCartId shoppingCartId, ClientId clientId) {
        this(shoppingCartId, clientId, new ArrayList<>());
    }

    @Override
    public ShoppingCartId id() {
        return shoppingCartId;
    }

    public ClientId clientId() {
        return clientId;
    }

    public Collection<ProductId> products() {
        return cart;
    }

    public ShoppingCart addProduct(ProductId productId) {
        cart.add( Objects.requireNonNull(productId) );
        eventLog.add(new ShoppingCartItemAddedEvent(shoppingCartId, clientId, productId));
        return this;
    }

    public ShoppingCart removeProduct(ProductId productId) {
        cart.remove( Objects.requireNonNull(productId) );
        eventLog.add(new ShoppingCartItemRemovedEvent(shoppingCartId, clientId, productId));
        return this;
    }

    public boolean hasExpired() {
        return Instant.now().isAfter(expirationDate);
    }
}
