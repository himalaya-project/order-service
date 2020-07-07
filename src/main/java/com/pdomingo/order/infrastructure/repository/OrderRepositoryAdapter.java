package com.pdomingo.order.infrastructure.repository;

import com.pdomingo.order.domain.model.Order;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.OrderId;
import com.pdomingo.order.domain.port.secondary.OrderRepository;

import java.util.Optional;

public class OrderRepositoryAdapter implements OrderRepository {
    @Override
    public Order createFrom(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return Optional.empty();
    }
}
