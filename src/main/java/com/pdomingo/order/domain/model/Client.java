package com.pdomingo.order.domain.model;

import com.pdoming.kernel.core.vobjects.Address;
import com.pdomingo.order.domain.model.ids.ClientId;

public class Client {

	private final ClientId clientId;
	private final Address  orderAddress;

	public Client(ClientId clientId, Address orderAddress) {
		this.clientId = clientId;
		this.orderAddress = orderAddress;
	}


	public ClientId id() {
		return clientId;
	}
}
