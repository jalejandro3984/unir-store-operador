package com.unir.store_core.service;

import com.unir.store_core.model.db.*;
import com.unir.store_core.model.request.WishlistRequest;
import com.unir.store_core.repository.ProductJpaRepository;
import com.unir.store_core.repository.WishlistItemJpaRepository;
import com.unir.store_core.repository.WishlistJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {
    private final ProductJpaRepository productJpaRepository;
    private final WishlistJpaRepository wishlistJpaRepository;
    private final WishlistItemJpaRepository wishlistItemJpaRepository;

    @Override
    public Boolean deleteWishlist(Long id) {
        Wishlist wishlist = wishlistJpaRepository.findById(id).orElse(null);

        if (null == wishlist) {
            return Boolean.FALSE;
        }

        wishlistJpaRepository.delete(wishlist);
        return Boolean.TRUE;
    }

    @Override
    public Wishlist addProduct(Long id, WishlistRequest request) {
        Wishlist wishlist = wishlistJpaRepository.findById(id).orElse(null);

        if (null == wishlist) {
            return null;
        }

        Product product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        boolean productExists = wishlist.getWishlistItems().stream()
                .anyMatch(item -> item.getProduct().getId().equals(product.getId()));

        if (!productExists) {
            WishlistItem newItem = new WishlistItem();
            newItem.setWishlist(wishlist);
            newItem.setProduct(product);
            wishlist.getWishlistItems().add(newItem);
            wishlistJpaRepository.save(wishlist);
        }

        return wishlist;
    }

    @Override
    public Wishlist removeProduct(Long id, WishlistRequest request) {
        Wishlist wishlist = wishlistJpaRepository.findById(id).orElse(null);

        if (null != wishlist.getWishlistItems()) {
            return wishlist;
        }

        WishlistItem wishlistItemToRemove = wishlist.getWishlistItems().stream()
                .filter(wishlistItem -> wishlistItem.getProduct().getId().equals(request.getProductId()))
                .findFirst()
                .orElse(null);

        if (null != wishlistItemToRemove) {
            wishlist.getWishlistItems().remove(wishlistItemToRemove);
            wishlistItemToRemove.setWishlist(null);

            wishlistJpaRepository.save(wishlist);
            wishlistItemJpaRepository.delete(wishlistItemToRemove);
        }

        return wishlist;
    }
}
