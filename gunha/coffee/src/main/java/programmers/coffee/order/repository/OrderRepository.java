package programmers.coffee.order.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import programmers.coffee.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
