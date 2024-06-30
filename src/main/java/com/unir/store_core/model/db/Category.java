package com.unir.store_core.model.db;

import com.unir.store_core.model.dto.CategoryDto;
import com.unir.store_core.model.request.CategoryRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public static Category fromRequest(CategoryRequest request) {
        return Category.builder()
                .name(request.getName())
                .build();
    }

    public void update(CategoryDto categoryDto) {
        this.name = (null != categoryDto.getName()) ? categoryDto.getName() : this.name;
    }
}
