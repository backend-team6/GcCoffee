package com.kahyun.gc_coffee.model.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.hibernate.procedure.ProcedureOutputs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@SpringBootTest
class ProductRepositoryTest {

    private final ProductRepository productRepository;
    private final PlatformTransactionManager transactionManager;
    private TransactionStatus status;

    @Autowired
    public ProductRepositoryTest(ProductRepository productRepository, PlatformTransactionManager transactionManager){
        this.productRepository=productRepository;
        this.transactionManager=transactionManager;
    }

    @BeforeEach
    void beforeEach(){
        status=transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    @AfterEach
    void afterEach(){
        transactionManager.rollback(status);
    }

    @Test
    @DisplayName("Product 저장 성공한다.")
    public void saveTest(){
        String productName="원두22";
        int price=35000;
        String category="에티오피아";

        ProductEntity product=ProductEntity.builder()
                .productName(productName)
                .price(price)
                .category(category)
                .createdAt(new Date())
                .build();

        ProductEntity savedProduct= productRepository.save(product);

        ProductEntity newProduct=ProductEntity.builder()
                .productId(savedProduct.getProductId())
                .productName(savedProduct.getProductName())
                .price(savedProduct.getPrice())
                .category(savedProduct.getCategory())
                .createdAt(savedProduct.getCreatedAt())
                .build();

        Assertions.assertThat(newProduct).isEqualTo(product);
    }

    @Test
    @DisplayName("Product 수정 성공한다.")
    void updateTest(){
        String productName="원두22";
        int price=35000;
        String category="에티오피아";

        ProductEntity product=ProductEntity.builder()
                .productName(productName)
                .price(price)
                .category(category)
                .createdAt(new Date())
                .build();

        ProductEntity savedProduct= productRepository.save(product);

        product.setProductName("원두 수정");
        product.setPrice(23000);
        ProductEntity updatedProduct = productRepository.findByProductId(savedProduct.getProductId());

        ProductEntity newProduct=ProductEntity.builder()
                .productId(updatedProduct.getProductId())
                .productName(updatedProduct.getProductName())
                .price(updatedProduct.getPrice())
                .category(updatedProduct.getCategory())
                .createdAt(updatedProduct.getCreatedAt())
                .build();

        Assertions.assertThat(newProduct).isEqualTo(product);

    }

    @Test
    @DisplayName("Product 삭제 성공한다.")
    void deleteTest(){
        long beforeCount=productRepository.count();

        String productName="원두22";
        int price=35000;
        String category="에티오피아";

        ProductEntity product=ProductEntity.builder()
                .productName(productName)
                .price(price)
                .category(category)
                .createdAt(new Date())
                .build();

        productRepository.save(product);

        long savedCount=productRepository.count();
        Assertions.assertThat(savedCount).isEqualTo(beforeCount+1);

        productRepository.delete(product);
        long deleteCount=productRepository.count();
        Assertions.assertThat(beforeCount).isEqualTo(deleteCount);

    }
}