package com.unir.store_core.service;

import com.unir.store_core.model.db.Cart;
import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.db.User;
import com.unir.store_core.model.db.Wishlist;
import com.unir.store_core.model.request.CartRequest;
import com.unir.store_core.model.request.WishlistRequest;
import com.unir.store_core.repository.CartJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import com.unir.store_core.repository.UserJpaRepository;
import com.unir.store_core.repository.WishlistJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartJpaRepository cartJpaRepository;
    private final ProductJpaRepository productJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public Cart createCart(CartRequest request) {
        User user = userJpaRepository.findById(request.getUserId()).orElse(null);

        if (null == user) {
            return null;
        }

        Cart existingCart = cartJpaRepository.findByUser(user);

        if (null != existingCart) {
            return null;
        }

        Cart cart = new Cart();

        cart.setUser(user);
        cart.setProducts(new ArrayList<>());

        return cartJpaRepository.save(cart);
    }

    @Override
    public Boolean deleteCart(Long id) {
        Cart cart = cartJpaRepository.findById(id).orElse(null);

        if (null == cart) {
            return Boolean.FALSE;
        }

        if (!cart.getProducts().isEmpty()) {
            for (Product product : cart.getProducts()) {
                product.setCart(null);
                productJpaRepository.save(product);
            }
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

        User user = cart.getUser();
        Product product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        if (!cart.getProducts().contains(product)) {
            cart.addProduct(product);
            cartJpaRepository.save(cart);
        }

        return cart;
    }

    @Override
    public Cart removeProduct(Long id, CartRequest request) {
        Cart cart = cartJpaRepository.findById(id).orElse(null);

        if (null == cart) {
            return null;
        }

        Product product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        product.setWishlist(null);
        productJpaRepository.save(product);

        return cart;
    }
}
