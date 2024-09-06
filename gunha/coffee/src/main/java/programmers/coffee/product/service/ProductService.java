package programmers.coffee.product.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import programmers.coffee.product.domain.Product;
import programmers.coffee.product.dto.NewProductDTO;
import programmers.coffee.product.dto.ProductDTO;
import programmers.coffee.product.repository.ProductRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public ProductDTO save(NewProductDTO productDTO) {
		log.info("===[ProductService.save] Start ===");
		Product product = Product.from(productDTO);
		log.info("===[ProductService.save] End ===");
		Product save = productRepository.save(product);
		log.info("Save : {}", save);
		return ProductDTO.from(save);
	}
}
