package com.pdomingo.order.domain.event.incoming;

import com.pdomingo.kernel.event.client.ClientDataUpdated;
import com.pdomingo.order.domain.model.ids.ClientId;

public class ClientDataUpdateEvent<F> extends ClientDataUpdated<ClientId, F> {
	public ClientDataUpdateEvent(ClientId sourceId, ClientDataUpdated.Field updatedField, F updatedValue) {
		super(sourceId, updatedField, updatedValue);
	}
}
