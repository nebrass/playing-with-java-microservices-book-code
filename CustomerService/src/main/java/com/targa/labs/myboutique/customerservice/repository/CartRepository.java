package com.targa.labs.myboutique.customerservice.repository;

import com.targa.labs.myboutique.customerservice.domain.Cart;
import com.targa.labs.myboutique.customerservice.domain.enumeration.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByStatus(CartStatus status);

    List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);

}
