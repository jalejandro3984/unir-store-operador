package com.unir.store_core.model.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "`category_id` cannot be null")
    @NotNull(message = "`category_id` cannot be empty")
    private Long categoryId;

    @NotNull(message= "`name` cannot be null")
    @NotNull(message= "`name` cannot be empty")
    private String name;

    @NotNull(message = "`description` cannot be null")
    @NotNull(message = "`description` cannot be empty")
    private String description;

    @NotNull(message = "`price` cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "`price` must be greater than 0")
    private BigDecimal price;

    private String image;
}
