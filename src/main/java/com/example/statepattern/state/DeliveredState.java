package com.example.statepattern.state;

import org.springframework.stereotype.Component;

@Component
public class DeliveredState implements OrderState {
    @Override
    public void processOrder(Order order) {
        throw new IllegalStateException("Order is already delivered");
    }
    
    @Override
    public void cancelOrder(Order order) {
        throw new IllegalStateException("Cannot cancel delivered order");
    }
    
    @Override
    public String getStateName() {
        return "DELIVERED";
    }
}