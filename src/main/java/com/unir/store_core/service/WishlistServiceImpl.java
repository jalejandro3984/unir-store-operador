package com.unir.store_core.service;

import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.db.User;
import com.unir.store_core.model.db.Wishlist;
import com.unir.store_core.model.request.WishlistRequest;
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
public class WishlistServiceImpl implements WishlistService {
    private final ProductJpaRepository productJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final WishlistJpaRepository wishlistJpaRepository;

    @Override
    public Wishlist createWishlist(WishlistRequest request) {
        User user = userJpaRepository.findById(request.getUserId()).orElse(null);

        if (null == user) {
            return null;
        }

        Wishlist existingWishlist = wishlistJpaRepository.findByUser(user);

        if (null != existingWishlist) {
            return null;
        }

        Wishlist wishlist = new Wishlist();

        wishlist.setUser(user);
        wishlist.setProducts(new ArrayList<>());

        return wishlistJpaRepository.save(wishlist);
    }

    @Override
    public Boolean deleteWishlist(Long id) {
        Wishlist wishlist = wishlistJpaRepository.findById(id).orElse(null);

        if (null == wishlist) {
            return Boolean.FALSE;
        }

        if (!wishlist.getProducts().isEmpty()) {
            for (Product product : wishlist.getProducts()) {
                product.setWishlist(null);
                productJpaRepository.save(product);
            }
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

        User user = wishlist.getUser();
        Product product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        if (!wishlist.getProducts().contains(product)) {
            wishlist.addProduct(product);
            wishlistJpaRepository.save(wishlist);
        }

        return wishlist;
    }

    @Override
    public Wishlist removeProduct(Long id, WishlistRequest request) {
        Wishlist wishlist = wishlistJpaRepository.findById(id).orElse(null);

        if (null == wishlist) {
            return null;
        }

        Product product = productJpaRepository.findById(request.getProductId()).orElse(null);

        if (null == product) {
            return null;
        }

        product.setWishlist(null);
        productJpaRepository.save(product);

        return wishlist;
    }
}
