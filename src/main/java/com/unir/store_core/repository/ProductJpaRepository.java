package com.unir.store_core.repository;

import com.unir.store_core.model.db.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
