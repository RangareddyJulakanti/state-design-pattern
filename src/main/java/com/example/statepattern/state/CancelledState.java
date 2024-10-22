package com.example.statepattern.state;

import org.springframework.stereotype.Component;

@Component
public class CancelledState implements OrderState {
    @Override
    public void processOrder(Order order) {
        throw new IllegalStateException("Cannot process cancelled order");
    }
    
    @Override
    public void cancelOrder(Order order) {
        throw new IllegalStateException("Order is already cancelled");
    }
    
    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}