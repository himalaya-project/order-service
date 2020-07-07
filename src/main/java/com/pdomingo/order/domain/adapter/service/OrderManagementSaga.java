package com.pdomingo.order.domain.adapter.service;

import com.pdomingo.events.order.OrderEvents.OrderCanceledEvent;

public class OrderManagementSaga {

    public void startSaga() {
        OrderCanceledEvent event;
    }
//
//    // --> ClientVerificationCommand
//    public void on(ClientVerificationSucceded event) { }
//    public void on(ClientVerificationFailed event) { }
//
//    // --> OrderBookingCommand
//    public void on(OrderBookingEvent event) { }
//
//    // --> OrderPaymentCommand
//    public void on(OrderPaymentSucceded event) { }
//    public void on(OrderPaymentFailed event) { }
//
//    // --> OrderBookingCancelCommand
//
//    // --> OrderCreated (todo ok)
//    // --> OrderCanceled (cliente decide cancelar)
}
