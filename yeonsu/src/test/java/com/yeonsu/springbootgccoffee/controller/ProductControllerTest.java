package com.yeonsu.springbootgccoffee.controller;

import com.yeonsu.springbootgccoffee.model.dto.ProductDTO;
import com.yeonsu.springbootgccoffee.model.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProductService productService;

    // 상품 추가 테스트 (유효성 검사)
    @Test
    @DisplayName("상품 추가 요청 시 productName, category, price 중 null이 있을 경우 BAD_REQUEST 응답")
    void testInsertProductValidationFail() {
        ProductDTO invalidProductDTO = new ProductDTO();
        invalidProductDTO.setProductName(null);
        invalidProductDTO.setPrice(null);

        ResponseEntity<String> response = restTemplate.postForEntity("/product", invalidProductDTO, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("productName, category, price 입력 다시 확인하세요");
    }

    @Test
    @DisplayName("상품을 추가하면 추가한 상품의 정보가 반환되어야 한다.")
    void testInsertProduct() {
        // given
        ProductDTO requestDTO = new ProductDTO();
        requestDTO.setProductName("콜드브루");
        requestDTO.setCategory("디카페인");
        requestDTO.setPrice(1000L);
        requestDTO.setDescription("콜드브루 디카페인!!");

        ProductDTO responseDTO = new ProductDTO();
        responseDTO.setProductName("콜드브루");
        responseDTO.setCategory("디카페인");
        responseDTO.setPrice(1000L);
        responseDTO.setDescription("콜드브루 디카페인!!");

        when(productService.insertProduct(any(ProductDTO.class))).thenReturn(responseDTO);

        ProductDTO result = productService.insertProduct(requestDTO);

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getProductName()).isEqualTo(requestDTO.getProductName());
        Assertions.assertThat(result.getCategory()).isEqualTo(requestDTO.getCategory());
        Assertions.assertThat(result.getPrice()).isEqualTo(requestDTO.getPrice());
        Assertions.assertThat(result.getDescription()).isEqualTo(requestDTO.getDescription());
    }
}