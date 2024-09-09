package org.example.model.service;

import com.fasterxml.uuid.Generators;
import org.example.model.dto.ProductsDTO;
import org.example.model.repository.ProductsRepository;
import org.example.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository repo;

    public void insert(ProductsDTO dto) throws SQLException {
        //ProductDTO dto = new ProductDTO(productName, category, price, description);
        //byte[] temp = IdUtil.createUUID();
        dto.setProductId(UUID.randomUUID());
        System.out.println("product id: " + dto.getProductId());
        repo.insert(dto);
        System.out.println("insertte product id and mame: " + dto.getProductId() + " : "  + dto.getProductName());
    }

    public List<ProductsDTO> list() throws SQLException {
        return repo.list();
    }

    public ProductsDTO findById(UUID productId) throws SQLException {
        return repo.findById(productId);
    }

    public void update(ProductsDTO productsDTO) throws SQLException{
        repo.update(productsDTO);
    }
}
