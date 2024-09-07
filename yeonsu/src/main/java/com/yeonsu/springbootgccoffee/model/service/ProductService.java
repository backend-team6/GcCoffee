package com.yeonsu.springbootgccoffee.model.service;

import com.yeonsu.springbootgccoffee.model.dto.ProductDTO;
import com.yeonsu.springbootgccoffee.model.entity.Product;
import com.yeonsu.springbootgccoffee.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDTO insertProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(UUID.randomUUID()); // UUID 생성
        product.setProductName(productDTO.getProductName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        // 저장된 Product 엔티티를 DTO로 변환
        return new ProductDTO(savedProduct);
    }
}
