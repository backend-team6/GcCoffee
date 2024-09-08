package org.example.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.OrdersDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrdersRepository {

    void insert(OrdersDTO dto) throws SQLException;
    List<OrdersDTO> selectAll()throws SQLException;

    void update(OrdersDTO dto)throws SQLException;
    //void delete(OrdersDTO dto)throws SQLException;
}
