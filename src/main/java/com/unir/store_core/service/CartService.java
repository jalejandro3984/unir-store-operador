package com.unir.store_core.service;

import com.unir.store_core.model.db.Cart;
import com.unir.store_core.model.request.CartRequest;

public interface CartService {
    Cart createCart(CartRequest request);
    Boolean deleteCart(Long id);
    Cart addProduct(Long id, CartRequest request);
    Cart removeProduct(Long id, CartRequest request);
}
