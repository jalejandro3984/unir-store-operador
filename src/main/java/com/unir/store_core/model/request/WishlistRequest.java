package com.unir.store_core.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistRequest {
    @NotNull(message = "`id` cannot be null")
    @NotEmpty(message = "`id` cannot be empty")
    private Long id;

    @NotNull(message = "`productId` cannot be null")
    @NotEmpty(message = "`productId` cannot be empty")
    private Long productId;
}
