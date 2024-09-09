package org.example.model.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import javax.annotation.processing.Generated;
import java.util.UUID;

public class ProductsDTO {
    private UUID productId;
    //private int productId;
    private String productName;
    private String category;
    private int price;
    private String description;
    private String created_at;
    private String updated_at;

    public ProductsDTO(){
    }

    public ProductsDTO( String productName, String category, int price, String description) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

 /*   public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }*/

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "ProductsDTO [productId=" + productId + ", productName=" + productName + ", category=" + category + ", price=" + price
                + ", description=" + description + "]";
    }
}
