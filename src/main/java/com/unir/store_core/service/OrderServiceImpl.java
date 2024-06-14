package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.request.OrderRequest;
import com.unir.store_core.repository.OrderJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import com.unir.store_core.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProductJpaRepository productJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Order createOrder(OrderRequest request) {
        var user = userJpaRepository.findById(request.getUserId());
        var product = productJpaRepository.findById(request.getProductId());

        if (user.isEmpty()) {
            return null;
        }

        if (product.isEmpty()) {
            return null;
        }

        Order order = new Order();
        order.setUser(user.get());
        order.setProducts(List.of(product.get()));

        return orderJpaRepository.save(order);
    }

    @Override
    public Boolean deleteOrder(Long id) {
        if(!orderJpaRepository.existsById(id)) {
            return Boolean.FALSE;
        }

        orderJpaRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
