package com.pdomingo.order.configuration.amqp;

import com.pdomingo.events.order.OrderEvents;
import com.pdomingo.order.domain.event.OrderCanceledEvent;
import com.pdomingo.order.domain.event.OrderCreatedEvent;
import com.pdomingo.order.domain.event.ShoppingCartItemAddedEvent;
import com.pdomingo.order.domain.event.ShoppingCartItemRemovedEvent;
import com.pdomingo.starter.amqp.service.EventMapper;

public class OrderEventMapper extends EventMapper {

    public OrderEventMapper() {
        register(OrderCreatedEvent.class, OrderEventMapper::mapOrderCreatedEvent);
        register(OrderCanceledEvent.class, OrderEventMapper::mapOrderCanceledEvent);
        register(ShoppingCartItemAddedEvent.class, OrderEventMapper::mapShoppingCartItemAddedEvent);
        register(ShoppingCartItemRemovedEvent.class, OrderEventMapper::mapShoppingCartItemRemovedEvent);
    }

    private static OrderEvents.OrderCreatedEvent mapOrderCreatedEvent(OrderCreatedEvent event) {
        return OrderEvents.OrderCreatedEvent.newBuilder()
                .setOrderId(event.sourceId().toString())
                .setClientId(event.clientId().toString())
                .setTimestamp(event.timestamp().getEpochSecond())
                .build();
    }

    private static OrderEvents.OrderCanceledEvent mapOrderCanceledEvent(OrderCanceledEvent event) {
        return OrderEvents.OrderCanceledEvent.newBuilder()
                .setOrderId(event.sourceId().toString())
                .setClientId(event.clientId().toString())
                .setTimestamp(event.timestamp().getEpochSecond())
                .build();
    }

    private static OrderEvents.ShoppingCartItemAddedEvent mapShoppingCartItemAddedEvent(ShoppingCartItemAddedEvent event) {
        return OrderEvents.ShoppingCartItemAddedEvent.newBuilder()
                .setShoppingCartId(event.sourceId().toString())
                .setClientId(event.clientId().toString())
                .setProductId(event.productId().toString())
                .setTimestamp(event.timestamp().getEpochSecond())
                .build();
    }

    private static OrderEvents.ShoppingCartItemRemovedEvent mapShoppingCartItemRemovedEvent(ShoppingCartItemRemovedEvent event) {
        return OrderEvents.ShoppingCartItemRemovedEvent.newBuilder()
                .setShoppingCartId(event.sourceId().toString())
                .setClientId(event.clientId().toString())
                .setProductId(event.productId().toString())
                .setTimestamp(event.timestamp().getEpochSecond())
                .build();
    }
}
