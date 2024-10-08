package programmers.coffee.product.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import programmers.coffee.product.dto.NewProductDTO;
import programmers.coffee.product.dto.ProductDTO;

@Entity
@Builder
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product {

	@Id
	// @Column(columnDefinition = "BINARY(16)")
	private UUID productId;

	private String productName;

	private String category;

	private Long price;

	private String description;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@PrePersist
	public void prePersist() {
		this.productId = UUID.randomUUID();
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	public static Product from(NewProductDTO newProductDTO) {
		return Product.builder()
			.productName(newProductDTO.getProductName())
			.category(newProductDTO.getCategory())
			.price(newProductDTO.getPrice())
			.description(newProductDTO.getDescription())
			.build();
	}

	public void updateProduct(ProductDTO productDTO) {
		this.productName = productDTO.getProductName();
		this.category = productDTO.getCategory();
		this.price = productDTO.getPrice();
		this.description = productDTO.getDescription();
	}

	public void deleteProduct() {
		this.category = "판매중지";
	}
}
