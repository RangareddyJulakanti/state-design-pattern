package com.example.statepattern.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessingState implements OrderState {

    @Autowired
    private ShippedState shippedState;

    @Override
    public void processOrder(Order order) {
        // Complete processing and move to shipped
        order.setState(shippedState);
        order.setStatus(OrderStatus.SHIPPED);
    }
    
    @Override
    public void cancelOrder(Order order) {
        // Cannot cancel once in processing
        throw new IllegalStateException("Cannot cancel order in processing state");
    }
    
    @Override
    public String getStateName() {
        return "PROCESSING";
    }
}
