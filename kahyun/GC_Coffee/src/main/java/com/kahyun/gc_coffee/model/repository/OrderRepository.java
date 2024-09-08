package com.kahyun.gc_coffee.model.repository;

import com.kahyun.gc_coffee.model.entity.OrderEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    @Modifying
    @Transactional
    @Query("delete from orders o where o.orderId = :orderId")
    void deleteByOrderId(@Param("orderId") UUID orderId);

    @Query("SELECT o FROM orders o WHERE o.orderId = :orderId")
    OrderEntity findOrderByOrderId(@Param("orderId") UUID orderId);
}
