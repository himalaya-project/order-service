package com.pdomingo.order.domain.model.ids;

import com.pdoming.kernel.core.ddd.DelegatedIdentifier;

import java.util.UUID;

public class OrderId extends DelegatedIdentifier<UUID> {
	public OrderId(UUID value) {
		super(value);
	}
	public OrderId(String value) {
		super(UUID.fromString(value));
	}
}
