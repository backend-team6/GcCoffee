package org.example.controller;

import org.example.model.dto.ProductsDTO;
import org.example.model.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/cafe")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping("/add")
    public void addProduct(@RequestBody ProductsDTO productsDTO) throws SQLException {
        productsService.insert(productsDTO);
    }
}
