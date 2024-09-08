package com.kahyun.gc_coffee.model.dto;

import com.kahyun.gc_coffee.model.entity.OrderEntity;
import com.kahyun.gc_coffee.model.entity.OrderItemsEntity;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {

    private int seq;
    private OrderEntity orderId;
    private ProductEntity productId;
    private String category;
    private int price;
    private int quantity;
    private Date createdAt;
    private Date updatedAt;

    public OrderItemsDTO(OrderItemsEntity entity){
        this.seq=entity.getSeq();
        this.orderId=entity.getOrderId();
        this.productId=entity.getProductId();
        this.category=entity.getCategory();
        this.price= entity.getPrice();
        this.quantity=entity.getQuantity();
        this.createdAt=entity.getCreatedAt();
        this.updatedAt=entity.getUpdatedAt();
    }

    public OrderItemsEntity toEntity(){
        OrderItemsEntity entity=new OrderItemsEntity();
        entity.setSeq(seq);
        entity.setOrderId(orderId);
        entity.setProductId(productId);
        entity.setCategory(category);
        entity.setPrice(price);
        entity.setQuantity(quantity);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        return entity;
    }

    public OrderItemsDTO(OrderEntity orderId, ProductEntity productId, String category, int price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}
