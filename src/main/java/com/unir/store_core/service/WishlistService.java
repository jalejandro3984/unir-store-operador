package com.unir.store_core.service;

import com.unir.store_core.model.db.Wishlist;
import com.unir.store_core.model.request.WishlistRequest;

public interface WishlistService {
    Wishlist createWishlist(WishlistRequest request);
    Boolean deleteWishlist(Long id);
    Wishlist addProduct(Long id, WishlistRequest request);
    Wishlist removeProduct(Long id, WishlistRequest request);
}
