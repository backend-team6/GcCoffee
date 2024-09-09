package com.yeonsu.springbootgccoffee.model.dto;

import com.yeonsu.springbootgccoffee.model.entity.Order;
import com.yeonsu.springbootgccoffee.model.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class OrderDTO {
    private UUID orderId;
    private String email;
    private String address;
    private String postcode;
    private String orderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Order order, List<OrderItem> orderItems) {
        this.orderId = order.getOrderId();
        this.email = order.getEmail();
        this.address = order.getAddress();
        this.postcode = order.getPostcode();
        this.orderStatus = order.getOrderStatus();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        this.orderItems = orderItems.stream().map(OrderItemDTO::new).collect(Collectors.toList());
    }
}
