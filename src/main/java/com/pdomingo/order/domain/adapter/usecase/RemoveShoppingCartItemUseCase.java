package com.pdomingo.order.domain.adapter.usecase;

import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.port.primary.usecase.shopping_cart.RemoveShoppingCartItem;
import com.pdomingo.order.domain.port.secondary.ShoppingCartRepository;
import com.pdomingo.order.infrastructure.web.mapper.ShoppingCartMapper;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;
import com.pdomingo.starter.amqp.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class RemoveShoppingCartItemAdapter implements RemoveShoppingCartItem {

    private final ShoppingCartRepository shoppingCartRepository;
    private final EventService eventService;

    @Override
    public ShoppingCartView remove(ClientId clientId, ProductId productId) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(productId);

        ShoppingCart shoppingCart = shoppingCartRepository.findActiveByClientId(clientId)
                .orElseThrow(IllegalStateException::new);
        shoppingCart.removeProduct(productId);

        if (shoppingCart.products().isEmpty()) {
            shoppingCartRepository.delete(shoppingCart.id());
        } else {
            shoppingCartRepository.save(shoppingCart);
        }

        shoppingCart.eventLog().forEach(eventService::send);

        return ShoppingCartMapper.toView(shoppingCart);
    }
}
