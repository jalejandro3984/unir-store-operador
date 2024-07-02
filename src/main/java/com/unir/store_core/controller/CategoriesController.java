package com.unir.store_core.controller;

import com.unir.store_core.model.db.Category;
import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.dto.CategoryDto;
import com.unir.store_core.model.request.CategoryRequest;
import com.unir.store_core.repository.CategoryJpaRepository;
import com.unir.store_core.service.CategoryService;
import com.unir.store_core.service.ProductService;
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
    private final ProductService productService;

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

    @GetMapping("/categories/{name}/products")
    public ResponseEntity<List<Product>> getAllProductsByCategory(@PathVariable String name) {
        Category category = repository.findByName(name);

        if (null == category) {
            return ResponseEntity.notFound().build();
        }

        List<Product> products = productService.getAllProductsByCategoryId(category.getId());
        return ResponseEntity.ok().body(products);
    }

    @PatchMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody CategoryDto body) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Category category = service.updateCategory(id, body);

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
