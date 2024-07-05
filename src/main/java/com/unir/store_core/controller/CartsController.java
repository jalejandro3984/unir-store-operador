package com.unir.store_core.controller;

import com.unir.store_core.model.db.Cart;
import com.unir.store_core.model.request.CartRequest;
import com.unir.store_core.repository.CartJpaRepository;
import com.unir.store_core.service.CartService;
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
    public ResponseEntity<Cart> createCart() {
        Cart cart = new Cart();
        repository.save(cart);

        return ResponseEntity.ok(cart);
    }

    @PostMapping("/carts/{id}/products")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long id, @RequestBody CartRequest request) {
        Cart cart = service.addProduct(id, request);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = repository.findAll();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Cart cart = repository.findById(id).orElse(null);

        if (null == cart) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        Boolean removed = service.deleteCart(id);

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/carts/{id}/products")
    public ResponseEntity<Cart> deleteProductFromCart(Long id, @RequestBody CartRequest request) {
        Cart cart = repository.findById(id).orElse(null);

        if (null == cart) {
            return ResponseEntity.notFound().build();
        }

        cart = service.removeProduct(id, request);

        return ResponseEntity.ok(cart);
    }
}
