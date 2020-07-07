package com.pdomingo.order.configuration.amqp;

import com.pdomingo.order.domain.event.ShoppingCartItemAddedEvent;
import com.pdomingo.order.domain.event.ShoppingCartItemRemovedEvent;
import com.pdomingo.starter.amqp.service.AmqpRoutingConfiguration;
import com.pdomingo.starter.amqp.service.EventMapper;
import com.pdomingo.starter.amqp.service.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    AmqpRoutingConfiguration routingConfiguration() {
        return AmqpRoutingConfiguration.builder()
                .newRoute(ShoppingCartItemAddedEvent.class, Route.from("shoppingCartExchange", "shopping-cart.item-added"))
                .newRoute(ShoppingCartItemRemovedEvent.class, Route.from("shoppingCartExchange", "shopping-cart.item-removed"))
                .build();
    }

    @Bean
    EventMapper orderEventMapper() {
        return new OrderEventMapper();
    }
}
