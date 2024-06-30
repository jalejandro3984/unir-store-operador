package com.unir.store_core.repository;

import com.unir.store_core.model.db.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistJpaRepository extends JpaRepository<Wishlist, Long> {
}
