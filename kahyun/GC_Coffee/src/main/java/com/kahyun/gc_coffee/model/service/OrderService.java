package com.kahyun.gc_coffee.model.service;

import com.kahyun.gc_coffee.model.dto.OrderDTO;
import com.kahyun.gc_coffee.model.dto.OrderItemsDTO;
import com.kahyun.gc_coffee.model.entity.OrderEntity;
import com.kahyun.gc_coffee.model.entity.OrderItemsEntity;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.repository.OrderItemRepository;
import com.kahyun.gc_coffee.model.repository.OrderRepository;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderItemsDTO order(OrderDTO order){
        OrderEntity orderEntity=order.toEntity();
        orderEntity.setOrderStatus("주문 완료");
        orderEntity.setCreatedAt(new Date());
        UUID orderId=orderRepository.save(orderEntity).getOrderId();

        ProductEntity productEntity=productRepository.findByProductId(order.getProductId());

        OrderItemsDTO orderItemsDTO=new OrderItemsDTO();
        orderItemsDTO.setOrderId(orderId);
        orderItemsDTO.setProductId(productEntity.getProductId());
        orderItemsDTO.setCategory(productEntity.getCategory());
        orderItemsDTO.setPrice(productEntity.getPrice());
        orderItemsDTO.setQuantity(order.getQuantity());
        orderItemsDTO.setCreatedAt(new Date());
        OrderItemsEntity orderItemsEntity=orderItemsDTO.toEntity();
        OrderItemsEntity result = orderItemRepository.save(orderItemsEntity);
        return new OrderItemsDTO(result);
    }
}
