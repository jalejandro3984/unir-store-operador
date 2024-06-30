package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.request.OrderRequest;
import com.unir.store_core.repository.OrderJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProductJpaRepository productJpaRepository;
    private final ProductService productService;
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order createOrder(OrderRequest request) {
        var product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        Order order = new Order();
//        order.setProducts(List.of(product));

        return orderJpaRepository.save(order);

//        try {
//            orderJpaRepository.save(order);
//        } catch (Exception e) {
//
//        }
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
