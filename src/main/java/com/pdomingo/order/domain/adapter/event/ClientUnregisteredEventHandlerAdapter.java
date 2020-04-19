package com.pdomingo.order.domain.adapter.event;

import com.pdomingo.order.domain.event.incoming.ClientUnregisteredEvent;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.port.primary.event.ClientUnregisteredEventHandler;
import com.pdomingo.order.domain.port.secondary.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientUnregisteredEventHandlerAdapter implements ClientUnregisteredEventHandler {

    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public void onClientUnregisteredEvent(ClientUnregisteredEvent event) {
        ClientId clientId = event.getSourceId();

        shoppingCartRepository.deleteAllFrom(clientId);
    }
}
