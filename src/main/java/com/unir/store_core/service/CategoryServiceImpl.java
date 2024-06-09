package com.unir.store_core.service;

import com.unir.store_core.model.db.Category;
import com.unir.store_core.repository.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryJpaRepository repository;

    @Override
    public Boolean removeCategory(Long id) {
        Category category = repository.findById(id).orElse(null);

        if (null == category) {
            return Boolean.FALSE;
        }

        repository.delete(category);

        return Boolean.TRUE;
    }
}
