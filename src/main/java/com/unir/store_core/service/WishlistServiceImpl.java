package com.unir.store_core.service;

import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.db.Wishlist;
import com.unir.store_core.model.request.WishlistRequest;
import com.unir.store_core.repository.ProductJpaRepository;
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

    @Override
    public Wishlist createWishlist(WishlistRequest request) {
        //TODO: agregar busqueda de usuario (un usuario tiene una wishlist). Si el usuario existe, crear wishlist, sino, retornar error.
        Wishlist wishlist = new Wishlist();
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
    public Wishlist addProduct(WishlistRequest request) {
        Wishlist wishlist = wishlistJpaRepository.findById(request.getId()).orElse(null);

        if (null == wishlist) {
            return null;
        }

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
    public Wishlist removeProduct(WishlistRequest request) {
        Wishlist wishlist = wishlistJpaRepository.findById(request.getId()).orElse(null);

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
