package com.pdomingo.order.domain.event.incoming;

import com.pdomingo.kernel.event.client.ClientUnregistered;
import com.pdomingo.order.domain.model.ids.ClientId;

import java.time.Instant;

public class ClientUnregisteredEvent extends ClientUnregistered<ClientId> {
	public ClientUnregisteredEvent(ClientId sourceId) {
		super(sourceId, Instant.now());
	}
}
