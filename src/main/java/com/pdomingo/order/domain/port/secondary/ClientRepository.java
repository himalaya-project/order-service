package com.pdomingo.order.domain.port.secondary;

import com.pdomingo.order.domain.model.Client;

public interface ClientRepository {

	Client save(Client newClient);
}
