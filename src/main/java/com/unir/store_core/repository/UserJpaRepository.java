package com.unir.store_core.repository;

import com.unir.store_core.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
