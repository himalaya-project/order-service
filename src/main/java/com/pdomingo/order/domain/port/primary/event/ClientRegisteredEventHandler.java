package com.pdomingo.order.domain.port.primary.event;

import com.pdomingo.events.client.ClientEvents;
import com.pdomingo.order.domain.event.outgoing.ClientRegisteredEvent;

public interface ClientRegisteredEventHandler {

	void onClientRegisteredEvent(ClientEvents.ClientRegisteredEvent event);
}
