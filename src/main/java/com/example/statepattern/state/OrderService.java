package com.example.statepattern.state;

import com.example.statepattern.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service implementation
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public Order createOrder(Order order) {
        // Initialize with new state
        order = new Order();
        return orderRepository.save(order);
    }
    
    public Order processOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.processOrder();
        return orderRepository.save(order);
    }
    
    public Order cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.cancelOrder();
        return orderRepository.save(order);
    }
}