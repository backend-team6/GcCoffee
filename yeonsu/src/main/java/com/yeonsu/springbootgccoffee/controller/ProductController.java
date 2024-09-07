package com.yeonsu.springbootgccoffee.controller;

import com.yeonsu.springbootgccoffee.model.dto.ProductDTO;
import com.yeonsu.springbootgccoffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> insertProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO result = productService.insertProduct(productDTO);
        return ResponseEntity.ok(result);
    }


}
