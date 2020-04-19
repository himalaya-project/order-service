package com.pdomingo.order.infrastructure.web.mapper;

import com.pdoming.kernel.core.ddd.DelegatedIdentifier;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartMapper {

    public static ShoppingCartView toView(ShoppingCart shoppingCart) {
        List<String> productIds = shoppingCart.products().stream()
                .map(DelegatedIdentifier::toString)
                .collect(Collectors.toUnmodifiableList());

        return productIds.isEmpty() ? ShoppingCartView.empty() : new ShoppingCartView(productIds);
    }
}
