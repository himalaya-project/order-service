package com.pdomingo.order.domain.model;

import com.pdomingo.kernel.core.ddd.AggregateRoot;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.OrderId;
import com.pdomingo.order.domain.model.ids.ProductId;

import java.util.Collection;

public class Order extends AggregateRoot<OrderId> {

	private final OrderId orderId;
	private final ClientId clientId;
	private final Collection<ProductId> products;
	private final OrderStatus status;

	public Order(OrderId orderId, ClientId clientId, Collection<ProductId> products, OrderStatus status) {
		this.orderId = orderId;
		this.clientId = clientId;
		this.products = products;
		this.status = status;
	}

	@Override
	public OrderId id() {
		return orderId;
	}
}
