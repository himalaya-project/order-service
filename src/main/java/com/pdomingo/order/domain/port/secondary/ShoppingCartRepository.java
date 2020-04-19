package com.pdomingo.order.domain.port.secondary;

import com.pdoming.kernel.core.ddd.Repository;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ShoppingCartId;

import java.util.Optional;

public interface ShoppingCartRepository extends Repository<ShoppingCart, ShoppingCartId> {

    Optional<ShoppingCart> findActiveByClientId(ClientId clientId);

    ShoppingCart create(ClientId clientId);

    void delete(ShoppingCartId shoppingCartId);

    ShoppingCart save(ShoppingCart shoppingCart);

    void deleteAllFrom(ClientId clientId);
}
