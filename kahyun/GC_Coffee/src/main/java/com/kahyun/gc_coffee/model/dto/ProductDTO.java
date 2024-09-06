package com.kahyun.gc_coffee.model.dto;


import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.Date;
import java.util.UUID;

public class ProductDTO {

    private UUID productId; //POST 요청이 들어올 때마다 id가 하나씩 증가하여 메뉴 리스트에 추가될 수 있도록 -> UUID는 랜덤인데...
    private String productName;
    private String category;
    private int price;
    private Date createdAt; //필요가 없나?
    private Date updatedAt;

    public ProductEntity toEntity(){
        ProductEntity entity=new ProductEntity();
        entity.setProductId(productId);
        entity.setProductName(productName);
        entity.setCategory(category);
        entity.setPrice(price);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);
        return entity;
    }

    public ProductDTO(ProductEntity entity){
        this.productId= entity.getProductId();
        this.productName= entity.getProductName();
        this.category= entity.getCategory();
        this.price= entity.getPrice();
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

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
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
