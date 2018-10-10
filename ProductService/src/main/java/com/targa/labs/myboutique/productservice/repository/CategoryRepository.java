package com.targa.labs.myboutique.productservice.repository;

import com.targa.labs.myboutique.productservice.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
