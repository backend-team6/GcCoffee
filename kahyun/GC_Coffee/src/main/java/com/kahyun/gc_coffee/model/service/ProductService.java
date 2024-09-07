package com.kahyun.gc_coffee.model.service;

import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean addProduct(ProductDTO productDTO){
        ProductEntity productEntity=productDTO.toEntity();
        productEntity.setCreatedAt(new Date());
        ProductEntity result = productRepository.save(productEntity);
        return result.getProductName().equals(productDTO.getProductName());
    }
}
