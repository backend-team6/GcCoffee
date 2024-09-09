package com.kahyun.gc_coffee.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import com.kahyun.gc_coffee.model.service.ProductService;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("상품을 등록할 수 있다.")
    public void addProductTest() throws Exception {
        //given
        ProductDTO productDTO = ProductDTO.builder()
                .productName("원두테스트")
                .category("테스트")
                .price(1234)
                .build();

        //when
        doNothing().when(productService).addProduct(any(ProductDTO.class));

        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


    @Test
    @DisplayName("상품을 수정할 수 있다.")
    public void updateProductTest() throws Exception {
        String existingProductId = "f47ac10b-58cc-4372-a567-0e02b2c3d479";

        // 수정할 상품 정보
        ProductDTO productDTO = ProductDTO.builder()
                .productId(existingProductId)
                .productName("원두테스트 수정")
                .category("테스트 수정")
                .price(12345)
                .updatedAt(new Date())
                .build();

        // When
        doNothing().when(productService).updateProduct(any(ProductDTO.class));

        // Then
        mockMvc.perform(MockMvcRequestBuilders.put("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
