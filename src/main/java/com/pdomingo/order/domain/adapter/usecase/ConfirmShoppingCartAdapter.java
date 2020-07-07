package com.pdomingo.order.domain.adapter.usecase;

import com.pdomingo.order.domain.exception.ShoppingCartNotFound;
import com.pdomingo.order.domain.model.Order;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.port.primary.usecase.shopping_cart.ConfirmShoppingCart;
import com.pdomingo.order.domain.port.secondary.OrderRepository;
import com.pdomingo.order.domain.port.secondary.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfirmShoppingCartAdapter implements ConfirmShoppingCart {

    private final OrderRepository orderRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public void confirm(ClientId clientId) {

        ShoppingCart shoppingCart = shoppingCartRepository.findActiveByClientId(clientId)
                .orElseThrow(() -> new ShoppingCartNotFound().with("clientId", clientId));

        // post-condition : every shopping cart has products

        Order order = orderRepository.createFrom(shoppingCart);

        // Steps to confirm a shopping cart

    }
}
