package org.example.model.dto;

import org.example.util.IdUtil;

import java.util.Date;
import java.util.UUID;

public class ProductsDTO {
     //byte[] productId;
    UUID productId;
    String productName;
    String category;
    int price;
    String description;
    String created_at;
    String updated_at;


    public ProductsDTO() {}

    public ProductsDTO(String productName, String category, int price, String description) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
    }

  /*  public String getProductId() {
        return IdUtil.bytesToHex(productId);
    }

    public void setProductId(byte[] productId) {
        this.productId = productId;
    }
*/
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String create_at) {
        this.created_at = create_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "ProdutcDTO [" + "productId=" + productId + ", productName="
                + productName + ", category=" + category + ", price=" + price + ", description=" + description
                + ", created_at=" + created_at + ", updated_at=" + updated_at + "]" + "\n";
    }
}
