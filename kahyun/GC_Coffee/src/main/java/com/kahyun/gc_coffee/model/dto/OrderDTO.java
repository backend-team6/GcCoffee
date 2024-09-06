package com.kahyun.gc_coffee.model.dto;


import com.kahyun.gc_coffee.model.entity.OrderEntity;
import java.util.Date;
import java.util.UUID;

public class OrderDTO {

    private UUID orderId;
    private String email;
    private String address;
    private String postcode;
    private String orderStatus;
    private Date createdAt;
    private Date updatedAt;
    private int Quantity;
    private UUID ProductId;

    public OrderDTO(OrderEntity entity){
        this.orderId=entity.getOrderId();
        this.email=entity.getEmail();
        this.address=entity.getAddress();
        this.postcode=entity.getPostcode();
        this.orderStatus=entity.getOrderStatus();
        this.createdAt=entity.getCreatedAt();
        this.updatedAt=entity.getUpdatedAt();
    }

    public OrderDTO(String email, String address, String postcode, String orderStatus, int quantity, UUID productId) {
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.orderStatus = orderStatus;
        Quantity = quantity;
        ProductId = productId;
    }

    public OrderEntity toEntity(){
        OrderEntity entity=new OrderEntity();
        entity.setOrderId(orderId);
        entity.setEmail(email);
        entity.setAddress(address);
        entity.setPostcode(postcode);
        entity.setOrderStatus(orderStatus);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        return entity;
    }

    public OrderDTO() {
    }

    public UUID getProductId() {
        return ProductId;
    }

    public void setProductId(UUID productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public OrderDTO(String email, String address, String postcode) {
        this.email = email;
        this.address = address;
        this.postcode = postcode;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
