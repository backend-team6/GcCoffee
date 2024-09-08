package com.kahyun.gc_coffee.model.dto;


import com.kahyun.gc_coffee.model.entity.OrderEntity;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private UUID orderIdUUID;
    private String orderId;
    private String email;
    private String address;
    private String postcode;
    private String orderStatus;
    private Date createdAt;
    private Date updatedAt;
    private List<ProductDTO> products;

    public OrderDTO(OrderEntity entity){
        this.orderIdUUID=entity.getOrderId();
        this.email=entity.getEmail();
        this.address=entity.getAddress();
        this.postcode=entity.getPostcode();
        this.orderStatus=entity.getOrderStatus();
        this.createdAt=entity.getCreatedAt();
        this.updatedAt=entity.getUpdatedAt();
    }

    public OrderEntity toEntity(){
        OrderEntity entity=new OrderEntity();
        entity.setOrderId(orderIdUUID);
        entity.setEmail(email);
        entity.setAddress(address);
        entity.setPostcode(postcode);
        entity.setOrderStatus(orderStatus);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        return entity;
    }
}
