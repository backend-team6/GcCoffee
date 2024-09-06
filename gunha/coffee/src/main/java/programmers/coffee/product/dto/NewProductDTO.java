package programmers.coffee.product.dto;

import lombok.Data;

@Data
public class NewProductDTO {
	private String productName;
	private String category;
	private Long price;
	private String description;
}
