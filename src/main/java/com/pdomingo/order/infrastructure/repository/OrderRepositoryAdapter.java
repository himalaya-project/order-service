package com.pdomingo.order.infrastructure.repository;

import com.pdomingo.order.domain.model.Order;
import com.pdomingo.order.domain.model.OrderStatus;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.OrderId;
import com.pdomingo.order.domain.port.secondary.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {
    @Override
    public Order createFrom(ShoppingCart shoppingCart) {
        Order newOrder = new Order(
                new OrderId(UUID.randomUUID()),
                shoppingCart.clientId(),
                shoppingCart.products(),
                OrderStatus.PENDING_PAYMENT
        );
        return newOrder;
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return Optional.empty();
    }
}
