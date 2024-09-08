package com.yeonsu.springbootgccoffee.controller;

import com.yeonsu.springbootgccoffee.model.dto.OrderDTO;
import com.yeonsu.springbootgccoffee.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    //고객 주문 내역 조회
    @GetMapping("/{email}")
    public ResponseEntity<?> selectOrders(@PathVariable String email) {
        List<OrderDTO> result = orderService.selectOrders(email);
        if (result == null) {
            return ResponseEntity.badRequest().body("productId에 해당하는 상품을 찾을 수 없어요!");
        }
        return ResponseEntity.ok(result);
    }

    //주문 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id); // order id 값 유효성 검사 - UUID 형식
            if (orderService.deleteOrder(uuid)) {
                return ResponseEntity.ok("주문 삭제 성공!");
            }
            return ResponseEntity.badRequest().body("삭제 실패");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("id UUID 형식으로 보내주세요~");
        }
    }
}
