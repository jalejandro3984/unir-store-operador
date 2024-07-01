package com.unir.store_core.repository;

import com.unir.store_core.model.db.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Id(Long categoryId);
}
