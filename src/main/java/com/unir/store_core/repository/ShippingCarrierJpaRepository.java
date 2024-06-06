package com.unir.store_core.repository;

import com.unir.store_core.model.db.ShippingCarrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingCarrierJpaRepository extends JpaRepository<ShippingCarrier, Long> {
}
