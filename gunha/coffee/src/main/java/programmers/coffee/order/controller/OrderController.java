package programmers.coffee.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import programmers.coffee.order.dto.OrderRequestDTO;
import programmers.coffee.order.service.OrderService;

@RestController
@RequiredArgsConstructor
@Slf4j
/**
 * Log 기록 코드 반복 발생 => AOP 적용으로 개선해야 함.
 */
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/order")
	public ResponseEntity<?> order(@RequestBody OrderRequestDTO requestDTO) {
		log.info("=== [OrderController.order] Start ===");

		log.info("=== [OrderService.order] Start ===");
		String status = orderService.order(requestDTO);
		log.info("=== [OrderService.order] End ===");

		log.info("Status : {}", status);
		log.info("=== [OrderController.order] End ===");
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
