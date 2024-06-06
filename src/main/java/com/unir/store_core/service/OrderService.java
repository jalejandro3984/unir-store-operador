package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;

public interface OrderService {
    Order createOrder(Order order);
}
