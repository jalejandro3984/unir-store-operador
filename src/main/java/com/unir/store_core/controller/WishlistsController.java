package com.unir.store_core.controller;

import com.unir.store_core.model.db.Wishlist;
import com.unir.store_core.model.request.WishlistRequest;
import com.unir.store_core.repository.WishlistJpaRepository;
import com.unir.store_core.service.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WishlistsController {
    private final WishlistJpaRepository repository;
    private final WishlistService service;

    @PostMapping("/wishlists")
    public ResponseEntity<Wishlist> createWishlist() {
        Wishlist wishlist = new Wishlist();
        repository.save(wishlist);

        return ResponseEntity.ok(wishlist);
    }

    @PostMapping("/wishlists/{id}/products")
    public ResponseEntity<Wishlist> addProductToWishlist(@PathVariable Long id, @RequestBody WishlistRequest request) {
        Wishlist wishlist = repository.findById(id).orElse(null);

        if (null == wishlist) {
            return ResponseEntity.notFound().build();
        }

        wishlist = service.addProduct(id, request);
        return ResponseEntity.ok(wishlist);
    }

    @GetMapping("/wishlists")
    public ResponseEntity<List<Wishlist>> getAllWishlists() {
        List<Wishlist> wishlists = repository.findAll();
        return ResponseEntity.ok(wishlists);
    }

    @GetMapping("/wishlists/{id}")
    public ResponseEntity<Wishlist> getWishlist(@PathVariable Long id) {
        Wishlist wishlist = repository.findById(id).orElse(null);

        if (null == wishlist) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(wishlist);
    }

    @DeleteMapping("/wishlists/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        Boolean removed = service.deleteWishlist(id);

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/wishlists/{id}/product")
    public ResponseEntity<Wishlist> deleteProductFromWishlist(@PathVariable Long id, @RequestBody WishlistRequest request) {
        Wishlist wishlist = repository.findById(id).orElse(null);

        if (null == wishlist) {
            return ResponseEntity.notFound().build();
        }

        wishlist = service.removeProduct(id, request);

        return ResponseEntity.ok(wishlist);
    }
}
