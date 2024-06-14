package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.request.OrderRequest;
import com.unir.store_core.repository.OrderJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import com.unir.store_core.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProductJpaRepository productJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        return orderJpaRepository.save(order);
    }

    @Override
    public Boolean deleteOrder(Long id) {
        return null;
    }
}
