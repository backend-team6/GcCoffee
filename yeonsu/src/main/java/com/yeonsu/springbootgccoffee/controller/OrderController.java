package com.yeonsu.springbootgccoffee.controller;

import com.yeonsu.springbootgccoffee.model.dto.OrderDTO;
import com.yeonsu.springbootgccoffee.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //주문 추가
    @PostMapping
    public ResponseEntity<?> insertOrder(@RequestBody OrderDTO orderDTO) {
        //유효성 검사 - email, address, postcode, orderItems        //orderItems.productDTO, orderItems.productDTO.productId, orderItems.quantity
        if (orderDTO.getEmail() == null || orderDTO.getAddress() == null || orderDTO.getPostcode() == null || orderDTO.getOrderItems().isEmpty()) {
            ResponseEntity.badRequest().body("입력 다시 확인하세요");
        }

        OrderDTO result = orderService.insertOrder(orderDTO);
        if (result == null) {
            return ResponseEntity.badRequest().body("productId에 해당하는 상품을 찾을 수 없어요!");
        }
        return ResponseEntity.ok(result);
    }
}
