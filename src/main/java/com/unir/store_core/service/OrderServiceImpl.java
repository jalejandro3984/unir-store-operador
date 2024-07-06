package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.db.OrderItem;
import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.request.OrderItemRequest;
import com.unir.store_core.model.request.OrderRequest;
import com.unir.store_core.repository.OrderJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProductJpaRepository productJpaRepository;
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order createOrder() {
        Order order = new Order();
        return orderJpaRepository.save(order);
    }

    @Transactional
    public Order addProductsToOrder(Long orderId, List<OrderItemRequest> requests) {
        Order order = orderJpaRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found.")); // Usa tu propia excepción personalizada

        for (OrderItemRequest request : requests) {
            Product product = productJpaRepository.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not found.")); // Usa tu propia excepción personalizada

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQty(request.getQty());
            order.getItems().add(item);
        }

        orderJpaRepository.save(order);

        return order;
    }

    @Transactional
    public Order removeProductFromOrder(Long orderId, Long productId) {
        Order order = orderJpaRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found.")); // Usa tu propia excepción personalizada

        OrderItem item = order.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found in the order.")); // Usa tu propia excepción personalizada

        order.getItems().remove(item);

        orderJpaRepository.save(order);

        return order;
    }

    @Transactional
    public Order updateOrderItem(Long orderId, Long productId, Integer quantity) {
        Order order = orderJpaRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found.")); // Usa tu propia excepción personalizada

        OrderItem item = order.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found in the order.")); // Usa tu propia excepción personalizada

        item.setQty(quantity);

        orderJpaRepository.save(order);

        return order;
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
