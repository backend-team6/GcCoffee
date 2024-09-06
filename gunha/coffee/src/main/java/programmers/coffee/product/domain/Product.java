package programmers.coffee.product.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import programmers.coffee.product.dto.NewProductDTO;

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
}
