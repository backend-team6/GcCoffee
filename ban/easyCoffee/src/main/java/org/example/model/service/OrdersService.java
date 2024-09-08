package org.example.model.service;

import org.example.model.dto.OrdersDTO;
import org.example.model.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository repo;

    public void insert(OrdersDTO dto) throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        dto.setCreated_at(now);
        dto.setOrderStatus(now);
        repo.insert(dto);
    }

    public List<OrdersDTO> selectAll() throws SQLException {
        System.out.println("service 실행");
        return repo.selectAll();
    }

    public void update(OrdersDTO dto) throws SQLException {
        LocalDateTime now = LocalDateTime.now();
        dto.setUpdated_at(now);
       // dto.setOrderStatus(now);
        repo.update(dto);
    }

}
