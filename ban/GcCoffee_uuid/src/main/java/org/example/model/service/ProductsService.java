package org.example.model.service;

import org.example.Util.UUIDUtil;
import org.example.model.dto.ProductsDTO;
import org.example.model.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.UUID;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository repo;

    public void insert(ProductsDTO dto) throws SQLException {
        UUID temp = UUID.randomUUID();
        System.out.println("new UUID  : "  +  temp);
        dto.setProductId(temp);
        repo.insert(dto);
    }
}
