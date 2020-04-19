package com.pdomingo.order.domain.adapter.event;

import com.pdomingo.order.domain.event.outgoing.ClientRegisteredEvent;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.port.primary.event.ClientRegisteredEventHandler;
import com.pdomingo.order.domain.port.secondary.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientRegisteredEventHandlerAdapter implements ClientRegisteredEventHandler {

	private final ClientRepository clientRepository;

	@Override
	public void onClientRegisteredEvent(ClientRegisteredEvent event) {

		ClientId clientId = event.getSourceId();

		log.info("Registering new client <{}> on database", clientId);
	}
}
