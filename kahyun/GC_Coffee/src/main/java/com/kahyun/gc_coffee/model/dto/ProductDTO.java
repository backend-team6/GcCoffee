package com.kahyun.gc_coffee.model.dto;


import com.kahyun.gc_coffee.model.entity.ProductEntity;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
