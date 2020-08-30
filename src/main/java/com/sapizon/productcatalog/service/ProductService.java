package com.sapizon.productcatalog.service;

import com.sapizon.productcatalog.model.ProductModel;
import com.sapizon.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(ProductModel product) {
        productRepository.save(product);
    }

    public void updateProduct(ProductModel product) {
        productRepository.update(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    public ProductModel getProduct(Long id) {
        return productRepository.find(id);
    }

    public List<ProductModel> getAllProducts() {
        Map<Long, ProductModel> productsMap = productRepository.findAll();
        return new ArrayList<>(productsMap.values());
    }
}
