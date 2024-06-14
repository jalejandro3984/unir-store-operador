package com.unir.store_core.repository;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
    Order findByUser(User user);
}
