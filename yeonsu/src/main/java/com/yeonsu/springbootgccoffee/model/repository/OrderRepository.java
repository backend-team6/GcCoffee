package com.yeonsu.springbootgccoffee.model.repository;

import com.yeonsu.springbootgccoffee.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByEmail(String email);
}
