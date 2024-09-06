package com.kahyun.gc_coffee.model.repository;

import com.kahyun.gc_coffee.model.entity.OrderItemsEntity;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemsEntity, Integer> {

}
