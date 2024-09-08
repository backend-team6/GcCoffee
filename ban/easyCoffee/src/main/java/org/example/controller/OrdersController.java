package org.example.controller;

import org.example.model.dto.OrdersDTO;
import org.example.model.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/add")
    public void addOrder(@RequestBody OrdersDTO dto) throws SQLException {
        ordersService.insert(dto);
    }

    @GetMapping("/list")
    public List<OrdersDTO> listOrders() throws SQLException {
        System.out.println("controller 실행");
        return ordersService.selectAll();
    }

  /*  @PutMapping("/update/{orderId)")
    public void orderUpdate(@PathVariable int orderId, @RequestBody OrdersDTO dto) throws SQLException {
        dto.setOrderId(orderId);
        ordersService.update(dto);
    }*/
}
