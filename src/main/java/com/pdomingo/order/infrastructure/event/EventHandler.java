package com.pdomingo.order.infrastructure.event;

import com.pdomingo.order.domain.event.outgoing.ClientRegisteredEvent;
import com.pdomingo.order.domain.port.primary.event.ClientRegisteredEventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventHandler {

	private final ClientRegisteredEventHandler clientRegisteredEventHandler;

	@RabbitListener(queues = "clientRegisteredQueue")
	void onClientRegisteredEvent(ClientRegisteredEvent event) {
		clientRegisteredEventHandler.onClientRegisteredEvent(event);
	}
}
