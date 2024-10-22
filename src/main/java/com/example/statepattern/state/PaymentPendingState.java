package com.example.statepattern.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentPendingState implements OrderState {
    @Autowired
    private CancelledState cancelledState;
    @Autowired
    private ProcessingState processingState;
    @Override
    public void processOrder(Order order) {
        // Process payment and move to processing
        order.setState(processingState);
        order.setStatus(OrderStatus.PROCESSING);
    }
    
    @Override
    public void cancelOrder(Order order) {
        order.setState(cancelledState);
        order.setStatus(OrderStatus.CANCELLED);
    }
    
    @Override
    public String getStateName() {
        return "PAYMENT_PENDING";
    }
}
