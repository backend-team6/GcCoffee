package com.yeonsu.springbootgccoffee.model.repository;

import com.yeonsu.springbootgccoffee.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
