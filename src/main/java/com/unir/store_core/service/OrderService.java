package com.unir.store_core.service;

import com.unir.store_core.model.db.Order;
import com.unir.store_core.model.request.OrderItemRequest;
import com.unir.store_core.model.request.OrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder();
    Order addProductsToOrder(Long orderId, List<OrderItemRequest> requests);
    Order removeProductFromOrder(Long orderId, Long productId);
    Order updateOrderItem(Long orderId, Long productId, Integer quantity);
    Boolean deleteOrder(Long id);
}
