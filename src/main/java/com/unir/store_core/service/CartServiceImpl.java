package com.unir.store_core.service;

import com.unir.store_core.model.db.Cart;
import com.unir.store_core.model.db.CartItem;
import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.request.CartRequest;
import com.unir.store_core.repository.CartItemJpaRepository;
import com.unir.store_core.repository.CartJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartJpaRepository cartJpaRepository;
    private final CartItemJpaRepository cartItemJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    @Override
    public Boolean deleteCart(Long id) {
        Cart cart = cartJpaRepository.findById(id).orElse(null);

        if (null == cart) {
            return Boolean.FALSE;
        }

        cartJpaRepository.delete(cart);
        return Boolean.TRUE;
    }

    @Override
    public Cart addProduct(Long id, CartRequest request) {
        Cart cart = cartJpaRepository.findById(id).orElse(null);

        if (null == cart) {
            return null;
        }

        Product product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElseGet(() -> {
                    CartItem newItem = new CartItem();
                    newItem.setCart(cart);
                    newItem.setProduct(product);
                    newItem.setQty(0);
                    cart.getCartItems().add(newItem);
                    return newItem;
                });

        cartItem.setQty(cartItem.getQty() + request.getQty());

        cartJpaRepository.save(cart);

        return cart;
    }

    @Override
    public Cart removeProduct(Long id, CartRequest request) {
        Cart cart = cartJpaRepository.findById(id).orElse(null);

        CartItem cartItemToRemove = cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(request.getProductId()))
                .findFirst()
                .orElse(null);

        if (null == cartItemToRemove) {
            return cart;
        }

        cart.getCartItems().remove(cartItemToRemove);
        cartItemToRemove.setCart(null);

        cartJpaRepository.save(cart);
        cartItemJpaRepository.delete(cartItemToRemove);

        return cart;
    }
}
