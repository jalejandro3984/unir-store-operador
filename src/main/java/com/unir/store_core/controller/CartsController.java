package com.unir.store_core.controller;

import com.unir.store_core.model.db.Cart;
import com.unir.store_core.model.request.CartRequest;
import com.unir.store_core.repository.CartJpaRepository;
import com.unir.store_core.repository.WishlistJpaRepository;
import com.unir.store_core.service.CartService;
import com.unir.store_core.service.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CartsController {
    private final CartJpaRepository repository;
    private final CartService service;

    @PostMapping("/carts")
    public ResponseEntity<Cart> createWishlist(@RequestBody CartRequest request) {
        Cart cart = service.createCart(request);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/carts/{id}/product/add")
    public ResponseEntity<Cart> addProductToWishlist(@PathVariable Long id, @RequestBody CartRequest request) {
        Cart cart = service.addProduct(id, request);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getAllWishlists() {
        List<Cart> carts = repository.findAll();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<Cart> getWishlist(@PathVariable Long id) {
        Cart cart = repository.findById(id).orElse(null);

        if (null == cart) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/carts/{id}/delete")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        Boolean removed = service.deleteCart(id);

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/carts/{id}/product/delete")
    public ResponseEntity<Cart> deleteProductFromWishlist(@PathVariable Long id, @RequestBody CartRequest request) {
        Cart cart = service.removeProduct(id, request);

        if (null == cart) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cart);
    }
}
