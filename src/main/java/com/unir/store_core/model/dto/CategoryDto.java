package com.unir.store_core.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CategoryDto {
    private String name;
    private String image;
}
