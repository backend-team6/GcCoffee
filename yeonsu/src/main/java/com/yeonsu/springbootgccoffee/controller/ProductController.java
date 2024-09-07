package com.yeonsu.springbootgccoffee.controller;

import com.yeonsu.springbootgccoffee.model.dto.ProductDTO;
import com.yeonsu.springbootgccoffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //상품 추가
    @PostMapping
    public ResponseEntity<?> insertProduct(@RequestBody ProductDTO productDTO) {
        //유효성 검사 - productName, category가 null이거나, price가 0일 떄
        if (productDTO.getProductName() == null || productDTO.getCategory() == null || productDTO.getPrice() == 0) {
            return ResponseEntity.badRequest().body("productName, category, price 입력 다시 확인해라");
        }

        ProductDTO result = productService.insertProduct(productDTO);
        return ResponseEntity.ok(result);
    }

    //전체 상품 조회
    @GetMapping
    public ResponseEntity<?> selectProducts() {
        List<ProductDTO> result = productService.selectProducts();
        return ResponseEntity.ok(result);
    }
}
