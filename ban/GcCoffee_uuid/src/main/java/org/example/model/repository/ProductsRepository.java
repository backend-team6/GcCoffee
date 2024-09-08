package org.example.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.ProductsDTO;

import java.sql.SQLException;

@Mapper
public interface ProductsRepository {

    void insert(ProductsDTO dto) throws SQLException;
}
