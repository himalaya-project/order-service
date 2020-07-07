package com.pdomingo.order.domain.port.secondary;

import com.pdomingo.kernel.core.ddd.Repository;
import com.pdomingo.order.domain.model.Order;
import com.pdomingo.order.domain.model.ShoppingCart;
import com.pdomingo.order.domain.model.ids.OrderId;

public interface OrderRepository extends Repository<Order, OrderId> {

    Order createFrom(ShoppingCart shoppingCart);
}
