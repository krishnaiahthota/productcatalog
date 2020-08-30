package com.sapizon.productcatalog.repository;

import com.sapizon.productcatalog.model.ProductModel;

import java.util.Map;

public interface ProductRepository {

    void save(ProductModel product);
    ProductModel find(Long id);
    void update(ProductModel product);
    void delete(Long id);
    Map<Long, ProductModel> findAll();
}
