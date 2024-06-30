package com.unir.store_core.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    @NotNull(message = "`cartId` cannot be null")
    private Long cartId;

    @NotNull(message = "`productId` cannot be null")
    @Min(value = 1, message = "`productId` must be greater than or equal to 1")
    private Long productId;

    @NotNull(message = "`qty` cannot be null")
    @Min(value = 1, message = "`qty` must be greater than or equal to 1")
    private Integer qty;
}
