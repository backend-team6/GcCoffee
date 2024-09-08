package org.example.controller;

import org.example.model.dto.ProductsDTO;

import org.example.model.service.ProductsService;
import org.example.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cafe")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/add")
    public void addProduct(@RequestBody ProductsDTO dto) throws SQLException {
        productsService.insert(dto);
    }

    @GetMapping("/list")
    public List<ProductsDTO> listProducts() throws SQLException {
        System.out.println("list 실행");
        List<ProductsDTO> list = productsService.list();
        System.out.println("list" + list.toString());
        return list;
    }

  /*  @GetMapping("/update/{productId}")
    public ProductsDTO updateProduct(@PathVariable UUID productId) throws SQLException {
        System.out.println("findById 실행");
        ProductsDTO productsDTO = productsService.findById(productId);
        //System.out.println("findByID" + productsDTO.toString());
       *//* System.out.println("findById" + dto.toString());
        System.out.println("upate 실행");
        productsService.update(dto);*//*
        return productsDTO;
    }*/
}
