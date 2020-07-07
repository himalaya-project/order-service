package com.pdomingo.order.domain.port.primary.event;

import com.pdomingo.kernel.core.vobjects.Address;
import com.pdomingo.kernel.event.client.ClientDataUpdated;
import com.pdomingo.order.domain.model.ids.ClientId;

public interface ClientDataUpdatedEventHandler {

	void onClientDataUpdatedEvent(ClientDataUpdated<ClientId, Address> event);
}
