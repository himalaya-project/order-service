package com.pdomingo.order.domain.adapter.usecase;

import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.port.primary.usecase.shopping_cart.DeleteShoppingCart;
import com.pdomingo.order.domain.port.secondary.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteShoppingCartAdapter implements DeleteShoppingCart {

    private final ShoppingCartRepository repository;

    @Override
    public void delete(ClientId clientId) {
        Objects.requireNonNull(clientId);

        repository.findActiveByClientId(clientId)
                .ifPresent(cart -> repository.delete(cart.id()));
    }
}
