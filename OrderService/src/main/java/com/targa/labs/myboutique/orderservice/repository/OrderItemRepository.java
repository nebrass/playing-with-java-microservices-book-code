package com.targa.labs.myboutique.orderservice.repository;

import com.targa.labs.myboutique.orderservice.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
