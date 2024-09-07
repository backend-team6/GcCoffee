package com.yeonsu.springbootgccoffee.model.repository;

import com.yeonsu.springbootgccoffee.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {


}
