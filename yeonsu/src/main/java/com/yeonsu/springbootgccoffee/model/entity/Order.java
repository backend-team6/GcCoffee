package com.yeonsu.springbootgccoffee.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "orders")
@Getter
@Setter
@ToString
public class Order {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID orderId;

    private String email;
    private String address;
    private String postcode;
    private String orderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
