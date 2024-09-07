package com.kahyun.gc_coffee.model.service;

import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.entity.ProductEntity;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EntityManager em;

    public void addProduct(ProductDTO productDTO){
        ProductEntity productEntity=productDTO.toEntity();
        productEntity.setCreatedAt(new Date());
        UUID uuid= productRepository.save(productEntity).getProductId();
        System.out.println("\t"+uuid);
    }

    @Transactional
    public void updateProduct(ProductDTO productDTO){
        UUID productId = fromHexString(productDTO.getProductId());
        ProductEntity product=em.find(ProductEntity.class, productId);

        product.setProductName(productDTO.getProductName());
        product.setUpdatedAt(new Date());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
    }

    public static UUID fromHexString(String hexString) {
        if (hexString.startsWith("0x")) {
            hexString = hexString.substring(2);
        }

        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            bytes[i] = (byte) Integer.parseInt(hexString.substring(2 * i, 2 * i + 2), 16);
        }

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }

}
