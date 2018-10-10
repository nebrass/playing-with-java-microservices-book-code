package com.targa.labs.myboutique.orderservice.repository;

import com.targa.labs.myboutique.orderservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
