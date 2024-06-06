package com.unir.store_core.repository;

import com.unir.store_core.model.db.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository  extends JpaRepository<Payment, Long> {
}
