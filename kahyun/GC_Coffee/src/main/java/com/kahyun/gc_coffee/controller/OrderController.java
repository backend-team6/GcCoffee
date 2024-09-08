package com.kahyun.gc_coffee.controller;

import com.kahyun.gc_coffee.model.dto.OrderDTO;
import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    //사용자 주문 : POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void order(@RequestBody OrderDTO order){
        orderService.order(order);
    }

    //주문 취소 : DELETE
    @DeleteMapping
    public void deleteOrder(@RequestBody OrderDTO order){
        orderService.deleteOrder(order.getOrderId());
    }


    //상품 목록 보내기 : GET
    @GetMapping
    @ResponseBody
    public List<ProductEntity> productList(){
        List<ProductEntity> products=orderService.productList();
        return products;
    }
}
