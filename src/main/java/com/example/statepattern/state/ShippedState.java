package com.example.statepattern.state;

public class ShippedState implements OrderState {
    @Override
    public void processOrder(Order order) {
        // Mark as delivered
        order.setState(new DeliveredState());
        order.setStatus(OrderStatus.DELIVERED);
    }
    
    @Override
    public void cancelOrder(Order order) {
        throw new IllegalStateException("Cannot cancel shipped order");
    }
    
    @Override
    public String getStateName() {
        return "SHIPPED";
    }
}