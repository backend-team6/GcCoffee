package com.kahyun.gc_coffee.model.repository;

import com.kahyun.gc_coffee.model.entity.OrderEntity;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    ProductEntity findByProductId(UUID productId);
}
