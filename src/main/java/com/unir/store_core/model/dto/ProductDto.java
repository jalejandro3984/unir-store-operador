package com.unir.store_core.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDto {
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
    private Boolean visible;
}
