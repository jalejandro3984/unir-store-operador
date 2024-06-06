package com.unir.store_core.repository;

import com.unir.store_core.model.db.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryJpaRepository extends JpaRepository<Country, Long> {
}
