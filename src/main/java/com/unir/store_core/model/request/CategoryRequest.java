package com.unir.store_core.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @NotNull(message= "`name` cannot be null")
    @NotNull(message= "`name` cannot be empty")
    private String name;

    @NotNull(message = "`image` cannot be null")
    @NotEmpty(message= "`image` cannot be null")
    private String image;
}
