package programmers.coffee.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import programmers.coffee.product.dto.NewProductDTO;
import programmers.coffee.product.dto.ProductDTO;
import programmers.coffee.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

	private final ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody NewProductDTO newProductDTO) {
		log.info("===[ProductController.saveProduct] Start ===");
		ProductDTO responseDTO = productService.save(newProductDTO);
		log.info("ProductDTO : {}", responseDTO);
		log.info("===[ProductController.saveProduct] End ===");
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
