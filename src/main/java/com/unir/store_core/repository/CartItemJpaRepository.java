package com.unir.store_core.repository;

import com.unir.store_core.model.db.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItem, Long> {
}
