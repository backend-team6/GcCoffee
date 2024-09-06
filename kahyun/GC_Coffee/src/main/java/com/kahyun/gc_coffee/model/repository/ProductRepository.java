package com.kahyun.gc_coffee.model.repository;

import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    ProductEntity findByProductId(UUID productId);
}
