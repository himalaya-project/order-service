package com.pdomingo.order.domain.event.outgoing;

import com.pdoming.kernel.core.vobjects.Address;
import com.pdoming.kernel.core.vobjects.Email;
import com.pdoming.kernel.core.vobjects.PhoneNumber;
import com.pdomingo.kernel.event.client.ClientRegistered;
import com.pdomingo.order.domain.model.ids.ClientId;

import java.time.Instant;

public class ClientRegisteredEvent extends ClientRegistered<ClientId> {
	public ClientRegisteredEvent(ClientId sourceId, Email email, PhoneNumber phoneNumber, Address orderAddress) {
		super(sourceId, Instant.now(), email, phoneNumber, orderAddress);
	}
}
