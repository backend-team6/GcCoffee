package com.kahyun.gc_coffee.controller;

import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //상품 추가 : POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductDTO product){
        productService.addProduct(product);
    }

    //상품 정보 수정 : PUT
    @PutMapping
    public void updateProduct(@RequestBody ProductDTO product){
        productService.updateProduct(product);
    }

}
