package com.kahyun.gc_coffee.model.dto;


import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.Date;
import java.util.UUID;

public class ProductDTO {

    private UUID productIdUUID;
    private String productId;
    private String productName;
    private String category;
    private int price;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private int quantity;

    public ProductEntity toEntity(){
        ProductEntity entity=new ProductEntity();
        entity.setProductId(productIdUUID);
        entity.setProductName(productName);
        entity.setCategory(category);
        entity.setPrice(price);
        entity.setDescription(description);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        return entity;
    }

    public ProductDTO(ProductEntity entity){
        this.productIdUUID= entity.getProductId();
        this.productName= entity.getProductName();
        this.category= entity.getCategory();
        this.price= entity.getPrice();
        this.description=entity.getDescription();
        this.createdAt= entity.getCreatedAt();
        this.updatedAt=entity.getUpdatedAt();
    }

    public ProductDTO() {
    }

    public ProductDTO(String productName, String category, int price) {
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public ProductDTO(String productName, String category, int price,String description) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description=description;
    }

    public ProductDTO(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getProductIdUUID() {
        return productIdUUID;
    }

    public void setProductIdUUID(UUID productIdUUID) {
        this.productIdUUID = productIdUUID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
