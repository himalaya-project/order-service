package com.pdomingo.order.infrastructure.web;

import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.ProductId;
import com.pdomingo.order.domain.port.primary.usecase.AddShoppingCartItem;
import com.pdomingo.order.domain.port.primary.usecase.DeleteShoppingCart;
import com.pdomingo.order.domain.port.primary.usecase.FetchShoppingCart;
import com.pdomingo.order.domain.port.primary.usecase.RemoveShoppingCartItem;
import com.pdomingo.order.infrastructure.web.mapper.ShoppingCartMapper;
import com.pdomingo.order.infrastructure.web.model.ShoppingCartView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoints.SHOPPING_CART_BASE_PATH)
@RequiredArgsConstructor
public class ShoppingCartApi {

    private final FetchShoppingCart fetchShoppingCart;
    private final DeleteShoppingCart deleteShoppingCart;
    private final AddShoppingCartItem addShoppingCartItem;
    private final RemoveShoppingCartItem removeShoppingCartItem;

    @GetMapping(Endpoints.FETCH_SHOPPING_CART)
    public ShoppingCartView fetchShoppingCart(@PathVariable String clientId) {
        ShoppingCartView shoppingCartView = fetchShoppingCart.fetch(new ClientId(clientId));

        return shoppingCartView;
    }

    @PutMapping(Endpoints.MODIFY_SHOPPING_CART)
    public ShoppingCartView addItemToShoppingCart(@PathVariable String clientId, @PathVariable String productId) {
        ShoppingCartView updatedShoppingCart = addShoppingCartItem.add(
                new ClientId(clientId),
                new ProductId(productId)
        );

        return updatedShoppingCart;
    }

    @DeleteMapping(Endpoints.MODIFY_SHOPPING_CART)
    public ShoppingCartView removeItemFromShoppingCart(@PathVariable String clientId, @PathVariable String productId) {
        ShoppingCartView updatedShoppingCart = removeShoppingCartItem.remove(
                new ClientId(clientId),
                new ProductId(productId)
        );

        return updatedShoppingCart;
    }

    @DeleteMapping(Endpoints.DELETE_SHOPPING_CART)
    public ShoppingCartView deleteShoppingCart(@PathVariable String clientId) {
        deleteShoppingCart.delete(new ClientId(clientId));

        return ShoppingCartView.empty();
    }
}
