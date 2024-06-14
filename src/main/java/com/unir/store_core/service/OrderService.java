package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.request.OrderRequest;

public interface OrderService {
    Order createOrder(OrderRequest request);
    Boolean deleteOrder(Long id);
}
