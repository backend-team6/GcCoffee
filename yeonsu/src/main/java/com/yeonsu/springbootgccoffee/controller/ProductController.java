package com.yeonsu.springbootgccoffee.controller;

import com.yeonsu.springbootgccoffee.model.dto.ProductDTO;
import com.yeonsu.springbootgccoffee.model.entity.Product;
import com.yeonsu.springbootgccoffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        if (productDTO.getProductName() == null || productDTO.getCategory() == null || productDTO.getPrice() == null) {
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

    //상품 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) {
        if (productDTO.getProductName() == null && productDTO.getCategory() == null && productDTO.getPrice() == null && productDTO.getDescription() == null) {
            return ResponseEntity.badRequest().body("입력값이 없는데 어떻게 수정을 하니");
        }

        try {
            UUID uuid = UUID.fromString(id); // id 값 유효성 검사 - UUID 형식
            Product product = productService.findProduct(uuid);

            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("해당 ID의 상품을 찾을 수 없어요!");
            }

            ProductDTO result = productService.updateProduct(product, productDTO);
            return ResponseEntity.ok(result);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("id UUID 형식으로 보내주세요~");
        }
    }

    //상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id); // id 값 유효성 검사 - UUID 형식
            if (productService.deleteProduct(uuid)) {
                return ResponseEntity.ok("삭제됐음!");
            }
            return ResponseEntity.badRequest().body("아숩지만 삭제 실패함");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("id UUID 형식으로 보내주세요~");
        }
    }
}
