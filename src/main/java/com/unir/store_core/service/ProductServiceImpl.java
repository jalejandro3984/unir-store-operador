package com.unir.store_core.service;

import com.unir.store_core.model.db.Category;
import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.request.ProductRequest;
import com.unir.store_core.repository.CategoryJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductJpaRepository productRepository;
    private final CategoryJpaRepository categoryRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        Long categoryId = request.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (null == category) {
            return null;
        }

        Product product = Product.fromRequest(request);

        return productRepository.save(product);
    }

    @Override
    public Boolean removeProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);

        if (null == product) {
            return Boolean.FALSE;
        }

        productRepository.delete(product);
        return Boolean.TRUE;
    }
}
