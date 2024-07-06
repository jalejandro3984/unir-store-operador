package com.unir.store_core.controller;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.request.OrderItemRequest;
import com.unir.store_core.repository.OrderJpaRepository;
import com.unir.store_core.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrdersController {
    private final OrderService service;
    private final OrderJpaRepository repository;

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = repository.findById(id).orElse(null);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder() {
        Order order = service.createOrder();
        return ResponseEntity.ok(order);
    }

    @PostMapping("/orders/{orderId}/products")
    public ResponseEntity<Order> addProductsToOrder(@PathVariable Long orderId, @RequestBody List<OrderItemRequest> requests) {
        Order order = service.addProductsToOrder(orderId, requests);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        Boolean result = service.deleteOrder(id);

        if (!result) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
