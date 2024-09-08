package com.yeonsu.springbootgccoffee.model.service;

import com.yeonsu.springbootgccoffee.model.dto.OrderDTO;
import com.yeonsu.springbootgccoffee.model.dto.OrderItemDTO;
import com.yeonsu.springbootgccoffee.model.entity.Order;
import com.yeonsu.springbootgccoffee.model.entity.OrderItem;
import com.yeonsu.springbootgccoffee.model.entity.Product;
import com.yeonsu.springbootgccoffee.model.repository.OrderItemRepository;
import com.yeonsu.springbootgccoffee.model.repository.OrderRepository;
import com.yeonsu.springbootgccoffee.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    public OrderDTO insertOrder(OrderDTO orderDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();

        Order order = new Order();
        order.setOrderId(UUID.randomUUID());
        order.setEmail(orderDTO.getEmail());
        order.setAddress(orderDTO.getAddress());
        order.setPostcode(orderDTO.getPostcode());
        order.setOrderStatus("출고전");
        order.setCreatedAt(localDateTime);

        // Order 저장
        Order savedOrder = orderRepository.save(order);

        // OrderItems 저장
        List<OrderItemDTO> orderItemDTOS = orderDTO.getOrderItems();
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO orderItemDTO: orderItemDTOS) {
            Product product = productRepository.findByProductId(orderItemDTO.getProductId());
            if (product == null) return null; //id에 해당하는 상품이 없을 때

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setCategory(product.getCategory());
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setCreatedAt(localDateTime);

            // OrderItem 저장
            OrderItem savedOrderItem = orderItemRepository.save(orderItem);

            orderItems.add(savedOrderItem);
        }

        return new OrderDTO(savedOrder, orderItems);
    }

    public List<OrderDTO> selectOrders(String email) {
        List<Order> orders = orderRepository.findByEmail(email);
        if (orders.isEmpty()) return null;

        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order: orders) {
            orderDTOS.add(new OrderDTO(order, orderItemRepository.findByOrder(order)));
        }

        return orderDTOS;
    }

    public boolean deleteOrder(UUID uuid) {
        try {
            orderRepository.deleteByOrderId(uuid); //삭제하고
            return !orderRepository.existsByOrderId(uuid);// 아직 존재한다면 return false, 삭제 되었으면 return true
        } catch (EmptyResultDataAccessException e) { //uuid에 해당하는 order가 없을 때
            return false;
        }
    }
}
