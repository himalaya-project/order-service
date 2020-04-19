package com.pdomingo.order.infrastructure.repository;

import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ShoppingCartId;
import com.pdomingo.order.domain.port.secondary.ShoppingCartRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {

    private Map<ShoppingCartId, ShoppingCart> storage;

    public ShoppingCartRepositoryAdapter() {
        this.storage = new HashMap<>();
    }

    @Override
    public Optional<ShoppingCart> findActiveByClientId(ClientId clientId) {
        Objects.requireNonNull(clientId);

        // SELECT * FROM shopping_cart WHERE client_id = ? AND expiration_date > ? (Today - livenessPeriod)

        return storage.values()
                .stream()
                .filter(cart -> cart.clientId().equals(clientId))
                .findFirst();
    }

    @Override
    public ShoppingCart create(ClientId clientId) {
        ShoppingCartId shoppingCartId = new ShoppingCartId(UUID.randomUUID());
        ShoppingCart shoppingCart = new ShoppingCart(shoppingCartId, clientId);

        storage.put(shoppingCartId, shoppingCart);
        return shoppingCart;
    }

    @Override
    public void delete(ShoppingCartId shoppingCartId) {
        storage.remove(shoppingCartId);
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        storage.put(shoppingCart.id(), shoppingCart);
        return shoppingCart;
    }

    @Override
    public void deleteAllFrom(ClientId clientId) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public Optional<ShoppingCart> findById(ShoppingCartId shoppingCartId) {
        return Optional.ofNullable(storage.get(shoppingCartId));
    }
}
