package com.unir.store_core.controller;

import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.dto.ProductDto;
import com.unir.store_core.model.request.ProductRequest;
import com.unir.store_core.repository.ProductJpaRepository;
import com.unir.store_core.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsController {
    private final ProductJpaRepository repository;
    private final ProductService service;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        Product product = service.createProduct(request);

        if (null == product) {
            return ResponseEntity
                    .badRequest()
                    .body("Failed to create the object. Please make sure the input is correct and try again.");
        }

        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = repository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = repository.findById(id).orElse(null);

        if (null == product) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto body) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Product product = service.updateProduct(id, body);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Boolean removed = service.removeProduct(id);

        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
