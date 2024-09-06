package com.kahyun.gc_coffee.model.repository;

import com.kahyun.gc_coffee.model.entity.OrderEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
