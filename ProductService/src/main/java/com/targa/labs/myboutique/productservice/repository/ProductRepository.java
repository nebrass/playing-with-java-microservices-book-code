package com.targa.labs.myboutique.productservice.repository;

import com.targa.labs.myboutique.productservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
