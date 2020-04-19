package com.pdomingo.order.domain.model.ids;

import com.pdoming.kernel.core.ddd.DelegatedIdentifier;

import java.util.UUID;

public class ShoppingCartId extends DelegatedIdentifier<UUID> {
    public ShoppingCartId(UUID value) {
        super(value);
    }
    public ShoppingCartId(String value) {
        super(UUID.fromString(value));
    }
}
