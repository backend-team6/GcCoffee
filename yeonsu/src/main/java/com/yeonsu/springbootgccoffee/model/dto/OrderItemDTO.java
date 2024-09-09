package com.yeonsu.springbootgccoffee.model.dto;

import com.yeonsu.springbootgccoffee.model.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class OrderItemDTO {
    private Long seq;
    private UUID productId;
//    private ProductDTO product; //productId
    private Integer quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.seq = orderItem.getSeq();
        this.productId = orderItem.getProduct().getProductId();
//        this.product = new ProductDTO(orderItem.getProduct());
        this.quantity = orderItem.getQuantity();
    }
}
