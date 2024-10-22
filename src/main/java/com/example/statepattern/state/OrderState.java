package com.example.statepattern.state;

public interface OrderState {
    void processOrder(Order order);
    void cancelOrder(Order order);
    String getStateName();
}