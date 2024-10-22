package com.example.statepattern.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewOrderState implements OrderState {

    @Autowired
    private PaymentPendingState paymentPendingState;

    @Autowired
    private CancelledState cancelledState;
    @Override
    public void processOrder(Order order) {
        // Process logic for new order
        order.setState(paymentPendingState);
        order.setStatus(OrderStatus.PAYMENT_PENDING);
    }
    
    @Override
    public void cancelOrder(Order order) {
        order.setState(cancelledState);
        order.setStatus(OrderStatus.CANCELLED);
    }
    
    @Override
    public String getStateName() {
        return "NEW";
    }
}
