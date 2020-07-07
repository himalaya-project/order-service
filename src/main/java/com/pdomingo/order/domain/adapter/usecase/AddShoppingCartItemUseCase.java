package com.pdomingo.order.domain.adapter.usecase;

import com.pdomingo.order.domain.adapter.service.ProductService;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.port.primary.usecase.shopping_cart.AddShoppingCartItem;
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
public class AddShoppingCartItemUseCase implements AddShoppingCartItem {

    private final ProductService productService;
    private final ShoppingCartRepository shoppingCartRepository;
    private final EventService eventService;

    @Override
    public ShoppingCartView add(ClientId clientId, ProductId productId) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(productId);

        ShoppingCart shoppingCart = shoppingCartRepository.findActiveByClientId(clientId)
                .orElseGet(() -> shoppingCartRepository.create(clientId));
        //Product product = productService.fetchProduct(productId);
        shoppingCart.addProduct(productId);

        shoppingCartRepository.save(shoppingCart);

        shoppingCart.eventLog().forEach(eventService::send);

        return ShoppingCartMapper.toView(shoppingCart);
    }
}
