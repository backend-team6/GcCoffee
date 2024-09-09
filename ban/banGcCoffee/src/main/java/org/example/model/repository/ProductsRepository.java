package org.example.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.ProductsDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Mapper
public interface ProductsRepository {
    void insert(ProductsDTO productsDTO) throws SQLException;
    //int update(ProductsDTO productsDTO) throws SQLException;
    List<ProductsDTO> list() throws SQLException;
    ProductsDTO findById(UUID id) throws SQLException;
    void update(ProductsDTO productsDTO) throws SQLException;
}
