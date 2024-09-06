package programmers.coffee.product.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import programmers.coffee.product.domain.Product;

@Data
@Builder
public class ProductDTO {

	private UUID productId;

	private String productName;

	private String category;

	private Long price;

	private String description;

	public static ProductDTO from(Product product) {
		return ProductDTO.builder()
			.productId(product.getProductId())
			.productName(product.getProductName())
			.category(product.getCategory())
			.price(product.getPrice())
			.description(product.getDescription())
			.build();
	}
}
