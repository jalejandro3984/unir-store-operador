package com.unir.store_core.repository;

import com.unir.store_core.model.db.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJpaRepository extends JpaRepository<Cart, Long> { }
