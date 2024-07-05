package com.unir.store_core.repository;

import com.unir.store_core.model.db.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemJpaRepository extends JpaRepository<WishlistItem, Long> {
}
