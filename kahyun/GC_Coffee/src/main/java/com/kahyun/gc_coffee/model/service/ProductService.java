package com.kahyun.gc_coffee.model.service;

import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(ProductDTO productDTO){
        ProductEntity productEntity=productDTO.toEntity();
        productEntity.setCreatedAt(new Date());
        productRepository.save(productEntity);
    }

}
