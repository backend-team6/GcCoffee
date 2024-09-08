package com.kahyun.gc_coffee.model.service;

import com.kahyun.gc_coffee.model.dto.OrderDTO;
import com.kahyun.gc_coffee.model.dto.OrderItemsDTO;
import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.entity.OrderEntity;
import com.kahyun.gc_coffee.model.entity.OrderItemsEntity;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.repository.OrderItemRepository;
import com.kahyun.gc_coffee.model.repository.OrderRepository;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public void order(OrderDTO order) {
        OrderEntity orderEntity = order.toEntity();
        orderEntity.setOrderStatus("주문 완료");
        orderEntity.setCreatedAt(new Date());
        orderRepository.save(orderEntity);

        for(ProductDTO product : order.getProducts()) {
            UUID productId = UUIDService.fromHexString(product.getProductId());
            ProductEntity productEntity = productRepository.findByProductId(productId);

            OrderItemsDTO orderItemsDTO = new OrderItemsDTO(orderEntity, productEntity, productEntity.getCategory(), productEntity.getPrice(), product.getQuantity());
            orderItemsDTO.setCreatedAt(new Date());
            OrderItemsEntity orderItemsEntity = orderItemsDTO.toEntity();
            orderItemRepository.save(orderItemsEntity);
        }
    }

    @Transactional
    public void deleteOrder(String orderId){
        OrderEntity orderEntity=orderRepository.findOrderByOrderId(UUIDService.fromHexString(orderId));
        orderRepository.deleteByOrderId(UUIDService.fromHexString(orderId));
        orderItemRepository.deleteByOrderId(orderEntity);
    }

    public List<ProductEntity> productList(){
        return productRepository.findAll();
    }
}
