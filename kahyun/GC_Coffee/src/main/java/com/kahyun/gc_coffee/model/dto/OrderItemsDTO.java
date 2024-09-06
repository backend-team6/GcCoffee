package com.kahyun.gc_coffee.model.dto;

import com.kahyun.gc_coffee.model.entity.OrderItemsEntity;
import java.util.Date;
import java.util.UUID;

public class OrderItemsDTO {

    private int seq;
    private UUID orderId;
    private UUID productId;
    private String category;
    private int price;
    private int quantity;
    private Date createdAt;
    private Date updatedAt;

    public OrderItemsDTO(OrderItemsEntity entity){
        this.seq=entity.getSeq();
        this.orderId=entity.getOrderId().getOrderId();
        this.productId=entity.getProductId().getProductId();
        this.category=entity.getCategory();
        this.price= entity.getPrice();
        this.quantity=entity.getQuantity();
        this.createdAt=entity.getCreatedAt();
        this.updatedAt=entity.getUpdatedAt();
    }

    public OrderItemsEntity toEntity(){
        OrderItemsEntity entity=new OrderItemsEntity();
        entity.setSeq(seq);
//        entity.setOrderId(orderId);
//        entity.setProductId(productId);
        entity.setCategory(category);
        entity.setPrice(price);
        entity.setQuantity(quantity);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        return entity;
    }


    public OrderItemsDTO() {
    }

    public OrderItemsDTO(UUID orderId, UUID productId, String category, int price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemsDTO(String category, int price, int quantity) {
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
