package com.pdomingo.order.domain.model;

import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.model.ids.OrderId;
import com.pdomingo.order.domain.model.ids.ProductId;

import java.util.Collection;

public class Order {

	private final OrderId orderId;
	private final ClientId clientId;

	private Collection<ProductId> products;

	public Order(OrderId orderId, ClientId clientId) {
		this.orderId = orderId;
		this.clientId = clientId;
	}
}
