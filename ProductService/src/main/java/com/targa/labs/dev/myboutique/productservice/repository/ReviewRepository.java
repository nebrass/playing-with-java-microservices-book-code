package com.targa.labs.dev.myboutique.productservice.repository;

import com.targa.labs.dev.myboutique.productservice.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
