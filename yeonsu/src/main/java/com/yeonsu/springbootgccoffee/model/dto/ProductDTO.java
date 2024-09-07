package com.yeonsu.springbootgccoffee.model.dto;

import com.yeonsu.springbootgccoffee.model.entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private String productName;
    private String category;
    private int price;

    public ProductDTO() {
    }

    private String description;

    public ProductDTO(Product product) {
        this.productName = product.getProductName();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }
}
