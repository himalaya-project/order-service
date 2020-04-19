package com.pdomingo.order.domain.port.primary.event;


import com.pdomingo.order.domain.event.outgoing.ClientRegisteredEvent;

public interface ClientRegisteredEventHandler {

	void onClientRegisteredEvent(ClientRegisteredEvent event);
}
