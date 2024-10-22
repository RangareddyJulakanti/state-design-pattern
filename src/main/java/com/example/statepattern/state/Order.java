package com.example.statepattern.state;
import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String orderNumber;
    private double amount;
    
    @Transient
    private OrderState state;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    public Order() {
        this.state = new NewOrderState();
        this.status = OrderStatus.NEW;
    }
    
    public void processOrder() {
        state.processOrder(this);
    }
    
    public void cancelOrder() {
        state.cancelOrder(this);
    }
    
    // Getters and setters
    public void setState(OrderState state) {
        this.state = state;
    }
    
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
