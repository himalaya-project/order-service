package com.pdomingo.order.domain.exception;

import java.util.HashMap;
import java.util.Map;

public class OrderDomainException extends RuntimeException {

    private final Map<String, Object> metadata;

    public OrderDomainException() {
        this.metadata = new HashMap<>(3);
    }

    public OrderDomainException with(String key, Object value) {
        this.metadata.put(key, value);
        return this;
    }
}
