package com.yeonsu.springbootgccoffee.model.repository;

import com.yeonsu.springbootgccoffee.model.entity.Order;
import com.yeonsu.springbootgccoffee.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
}
