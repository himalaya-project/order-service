package com.pdomingo.order.domain.event;

import com.pdomingo.kernel.core.ddd.BaseDomainEvent;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.OrderId;

import java.time.Instant;

public class OrderCreatedEvent extends BaseDomainEvent<OrderId> {

    private final ClientId clientId;

    public OrderCreatedEvent(OrderId sourceId, Instant timestamp, ClientId clientId) {
        super(sourceId, timestamp);
        this.clientId = clientId;
    }

    public ClientId clientId() {
        return clientId;
    }
}
