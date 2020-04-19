package com.pdomingo.order.configuration.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties("shopping-cart")
public class ShoppingCartConfiguration {

    private Duration livenessPeriod;

}
