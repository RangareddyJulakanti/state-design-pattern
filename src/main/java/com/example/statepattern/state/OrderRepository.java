// First, let's define the JPA Repository
package com.example.statepattern.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom finder methods
    List<Order> findByStatus(OrderStatus status);
    List<Order> findByOrderNumber(String orderNumber);
    List<Order> findByAmountGreaterThan(double amount);
    
    // Custom query example
    @Query("SELECT o FROM Order o WHERE o.status = :status AND o.amount > :amount")
    List<Order> findOrdersByStatusAndAmountGreaterThan(
        @Param("status") OrderStatus status,
        @Param("amount") double amount
    );
    
    // Count orders by status
    @Query("SELECT COUNT(o) FROM Order o WHERE o.status = :status")
    long countOrdersByStatus(@Param("status") OrderStatus status);
    
    // Find orders within date range
    @Query("SELECT o FROM Order o WHERE o.createdDate BETWEEN :startDate AND :endDate")
    List<Order> findOrdersBetweenDates(
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate
    );
}