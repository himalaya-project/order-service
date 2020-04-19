package com.pdomingo.order.domain.port.primary.event;

import com.pdomingo.order.domain.event.incoming.ClientUnregisteredEvent;

public interface ClientUnregisteredEventHandler {

	void onClientUnregisteredEvent(ClientUnregisteredEvent event);
}
