package com.unir.store_core.model.db;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "wishlists")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishlistItem> wishlistItems = new ArrayList<>();

    public void setWishlistItems(List<WishlistItem> wishlistItems) {
        this.wishlistItems.clear();
        if (wishlistItems != null) {
            wishlistItems.forEach(wishlistItem -> {
                addCartItem(wishlistItem);
            });
        }
    }

    public void addCartItem(WishlistItem wishlistItem) {
        wishlistItems.add(wishlistItem);
        wishlistItem.setWishlist(this);
    }
}
