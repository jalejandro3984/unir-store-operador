package com.unir.store_core.service;

import com.unir.store_core.model.db.Category;
import com.unir.store_core.model.db.Product;
import com.unir.store_core.model.dto.ProductDto;
import com.unir.store_core.model.request.ProductRequest;
import com.unir.store_core.repository.CategoryJpaRepository;
import com.unir.store_core.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductJpaRepository productRepository;
    private final CategoryJpaRepository categoryRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        //TODO: buscar producto en el ms buscador, si el producto no existe, crearlo, si existe aumentar la cantidad.
        Long categoryId = request.getCategoryId();
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (null == category) {
            return null;
        }

        Product product = Product.fromRequest(request);

        return productRepository.save(product);
    }

    // @Override
    // public Product updateProduct(Long id, ProductRequest request) {
    //     //TODO: buscar producto en el ms buscador, si el producto no existe, crearlo, si existe aumentar la cantidad.
    //     Product producta = productRepository.getReferenceById(id);
    //     Long categoryId = request.getCategoryId();
    //     Category category = categoryRepository.findById(categoryId).orElse(null);

    //     if (null == category) {
    //         return null;
    //     }

    //     Product product = Product.fromRequest(request);

    //     return productRepository.save(product);
    // }

    @Override
    public Boolean removeProduct(Long id) {
        //TODO: Buscar producto en el buscador, validar cantidades, hacer una disminucion de la cantidad, si es igual a 0, volver no visible.
        Product product = productRepository.findById(id).orElse(null);

        if (null == product) {
            return Boolean.FALSE;
        }

        productRepository.delete(product);
        return Boolean.TRUE;
    }

    @Override
    public Product updateProduct(Long id, ProductDto body) {
        Product product = productRepository.getReferenceById(id);

        product.update(body);

        return productRepository.save(product);
    }

    public List<Product> getAllProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }
}
