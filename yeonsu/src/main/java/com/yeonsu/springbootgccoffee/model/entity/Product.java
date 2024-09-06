package com.yeonsu.springbootgccoffee.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "products")
@Getter
@Setter
@ToString
public class Product {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID productId;

    private String productName;
    private String category;
    private int price;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
