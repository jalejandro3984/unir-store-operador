package com.unir.store_core.controller;

import com.unir.store_core.model.db.Category;
import com.unir.store_core.model.request.CategoryRequest;
import com.unir.store_core.repository.CategoryJpaRepository;
import com.unir.store_core.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoriesController {
    private final CategoryJpaRepository repository;
    private final CategoryService service;

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest request) {
        Category data = Category.fromRequest(request);
        Category category  = repository.save(data);

        return ResponseEntity.ok(category);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = repository.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Category category = repository.findById(id).orElse(null);

        if (null == category) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Boolean removed = service.removeCategory(id);

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
