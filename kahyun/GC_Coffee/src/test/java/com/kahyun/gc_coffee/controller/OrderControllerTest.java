package com.kahyun.gc_coffee.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kahyun.gc_coffee.model.dto.OrderDTO;
import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.repository.OrderItemRepository;
import com.kahyun.gc_coffee.model.repository.OrderRepository;
import com.kahyun.gc_coffee.model.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @MockBean
    private OrderService orderService;
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private OrderItemRepository orderItemRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("주문할 수 있다.")
    public void saveOrder() throws Exception {
        //given
        List<ProductDTO> products=new ArrayList<>();
        products.add(ProductDTO.builder()
                .productId("f47ac10b-58cc-4372-a567-0e02b2c3d479")
                .quantity(32)
                .build());

        OrderDTO orderDTO = OrderDTO.builder()
                .email("test@test.com")
                .address("테스트 주소 1111")
                .postcode("1234")
                .products(products)
                .build();

        //when
        doNothing().when(orderService).order(any(OrderDTO.class));

        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("주문을 취소할 수 있다.")
    public void deleteOrder() throws Exception {
        //given
        String orderId="f47ac10b-58cc-4372-a567-0e02b2c3d479";

        //when
        doNothing().when(orderService).deleteOrder(orderId);

        //then
        mockMvc.perform(MockMvcRequestBuilders.delete("/order/delete/"+orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("상품 목록을 보낼 수 있다.")
    public void productList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

