package com.unir.store_core.model.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unir.store_core.model.dto.ProductDto;
import com.unir.store_core.model.request.ProductRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @JsonIgnore
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "qty")
    private Integer qty;

    public void update(ProductDto productDto) {
        this.name = (null != productDto.getName()) ? productDto.getName() : this.name;
        this.price = (null != productDto.getPrice()) ? productDto.getPrice() : this.price;
        this.description = (null != productDto.getDescription()) ? productDto.getDescription() : this.description;
        this.image = (null != productDto.getImage()) ? productDto.getImage() : this.image;
    }

    public static Product fromRequest(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .image(request.getImage())
                .visible(request.getVisible())
                .qty(request.getQty())
                .categoryId(request.getCategoryId())
                .build();
    }
}
