package com.pdomingo.order.domain.adapter.usecase;

import com.pdomingo.order.domain.exception.ShoppingCartNotFound;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.port.primary.usecase.shopping_cart.FetchShoppingCart;
import com.pdomingo.order.domain.port.secondary.ShoppingCartRepository;
import com.pdomingo.order.infrastructure.web.mapper.ShoppingCartMapper;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FetchShoppingCartAdapter implements FetchShoppingCart {

    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartView fetch(ClientId clientId) {
        log.info("Fetching active shopping cart for client <{}>", clientId);
        return shoppingCartRepository.findActiveByClientId(clientId)
                .map(ShoppingCartMapper::toView)
                .orElseThrow(() -> new ShoppingCartNotFound().with("clientId", clientId));
    }
}
