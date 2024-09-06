package com.kahyun.gc_coffee.controller;

import com.kahyun.gc_coffee.model.dto.OrderDTO;
import com.kahyun.gc_coffee.model.dto.OrderItemsDTO;
import com.kahyun.gc_coffee.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //사용자 주문 : POST
    @PostMapping
    public ResponseEntity<String> Order(@ModelAttribute OrderDTO order){
        OrderItemsDTO result = orderService.order(order);
        if(result.getQuantity()==order.getQuantity())
            return ResponseEntity.ok().body("성공");
        else
            return ResponseEntity.status(500).body("DB 저장 실패");
    }

    //주문 취소 : DELETE


    //상품 목록 보내기 : GET
}
