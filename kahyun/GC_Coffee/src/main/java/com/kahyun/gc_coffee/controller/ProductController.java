package com.kahyun.gc_coffee.controller;

import com.kahyun.gc_coffee.model.dto.ProductDTO;
import com.kahyun.gc_coffee.model.repository.ProductRepository;
import com.kahyun.gc_coffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    //상품 추가 : POST
    @PostMapping
    public String addProduct(@RequestBody ProductDTO product){
        if(productService.addProduct(product)){
            return "추가 성공";
        }
        else{
            return "DB 삽입 살패";
        }
    }

    //상품 정보 수정 : PUT
}
