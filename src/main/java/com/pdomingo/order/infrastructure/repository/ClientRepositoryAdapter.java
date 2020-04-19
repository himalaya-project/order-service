package com.pdomingo.order.infrastructure.repository;

import com.pdomingo.order.domain.model.Client;
import com.pdomingo.order.domain.model.ids.ClientId;
import com.pdomingo.order.domain.port.secondary.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    Map<ClientId, Client> storage;

    public ClientRepositoryAdapter() {
        storage = new HashMap<>();
    }

    @Override
    public Client save(Client newClient) {
        storage.put(newClient.id(), newClient);
        return newClient;
    }
}
