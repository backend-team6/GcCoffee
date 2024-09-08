package com.kahyun.gc_coffee.model.service;

import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final EntityManager em;

    public void addProduct(ProductDTO productDTO){
        ProductEntity productEntity=productDTO.toEntity();
        productEntity.setCreatedAt(new Date());
        UUID uuid= productRepository.save(productEntity).getProductId();
        System.out.println("\t"+uuid);
    }

    @Transactional
    public void updateProduct(ProductDTO productDTO){
        UUID productId = UUIDService.fromHexString(productDTO.getProductId());
        ProductEntity product=em.find(ProductEntity.class, productId);

        product.setProductName(productDTO.getProductName());
        product.setUpdatedAt(new Date());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
    }
}
