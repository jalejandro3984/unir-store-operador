package com.unir.store_core.model.db;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

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

//    @OneToMany(mappedBy = "wishlist", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JsonManagedReference
//    private List<Product> products;
//
//    public void addProduct(Product product) {
//        product.setWishlist(this);
//        this.products.add(product);
//    }
}
