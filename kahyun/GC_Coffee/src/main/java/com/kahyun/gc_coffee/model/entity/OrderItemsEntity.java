package com.kahyun.gc_coffee.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity(name="order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderEntity orderId;
    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductEntity productId;
    private String category;
    private int price;
    private int quantity;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
}
