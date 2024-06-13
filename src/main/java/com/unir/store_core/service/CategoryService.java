package com.unir.store_core.service;

import com.unir.store_core.model.db.Category;
import com.unir.store_core.model.dto.CategoryDto;

public interface CategoryService {
    Boolean removeCategory(Long id);
    Category updateCategory(Long id, CategoryDto body);
}
