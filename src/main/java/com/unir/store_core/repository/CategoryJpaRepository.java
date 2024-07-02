package com.unir.store_core.repository;

import com.unir.store_core.model.db.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
