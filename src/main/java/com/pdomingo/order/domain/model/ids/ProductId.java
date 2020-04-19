package com.pdomingo.order.domain.model.ids;

import com.pdoming.kernel.core.ddd.DelegatedIdentifier;

import java.util.UUID;

public class ProductId extends DelegatedIdentifier<UUID> {
    public ProductId(UUID value) {
        super(value);
    }
    public ProductId(String value) {
        super(UUID.fromString(value));
    }
}
