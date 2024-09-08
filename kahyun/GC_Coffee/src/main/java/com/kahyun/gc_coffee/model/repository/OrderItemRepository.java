package com.kahyun.gc_coffee.model.repository;

import com.kahyun.gc_coffee.model.entity.OrderEntity;
import com.kahyun.gc_coffee.model.entity.OrderItemsEntity;
import java.util.UUID;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderItemRepository extends JpaRepository<OrderItemsEntity, Integer> {

    void deleteByOrderId(OrderEntity orderEntity);
}
