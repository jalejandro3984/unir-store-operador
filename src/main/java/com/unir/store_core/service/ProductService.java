package com.unir.store_core.service;

import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.dto.ProductDto;
import com.unir.store_core.model.request.ProductRequest;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest request);
    Boolean removeProduct(Long id);
    Product updateProduct(Long id, ProductDto body);
    List<Product> getAllProductsByCategoryId(Long categoryId);
}
